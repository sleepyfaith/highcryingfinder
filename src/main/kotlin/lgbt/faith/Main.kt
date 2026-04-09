package lgbt.faith

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.pow

val RESULTS_FILE = File("results.txt")

fun main(args: Array<String>) = runBlocking {
    Args.init(args)
    val transformData = buildTransforms()


    RESULTS_FILE.createNewFile()
    RESULTS_FILE.writeText("")


    val totalBlocks = transformData.portalOffsets.size
    val p = probAtLeast(totalBlocks, Args.MIN_CRYING, 0.15)

    val chunkTotal = chunkCount(Args.SEARCH_RADIUS)

    val searchLocations = chunkTotal * (Args.Y_MAX - Args.Y_MIN) * transformData.transforms.size
    val expectedHits = searchLocations * p

    println(
        "starting ${formatChunks(chunkTotal)} search for " +
                "${Args.PORTAL_TYPE} with at least ${Args.MIN_CRYING}/$totalBlocks crying blocks " +
                "(1 in ${formatLarge(probabilityToOneIn(p))})..."
    )

    println("expected hits: ${formatLarge(expectedHits)}")

    val startTime = System.currentTimeMillis()

    val step = ((Args.SEARCH_RADIUS * 2) / Args.THREADS) + 1
    val jobs = List(Args.THREADS) { t ->

        val startX = -Args.SEARCH_RADIUS + t * step
        val endX = minOf(startX + step - 1, Args.SEARCH_RADIUS)

        launch(Dispatchers.Default) {
            findCoords(startX, endX, transformData)
        }
    }

    jobs.joinAll()

    println("finished in ${System.currentTimeMillis() - startTime}ms")
}