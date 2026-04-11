package lgbt.faith

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

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

    val requiredRadius = ((kotlin.math.sqrt(1.0 / (p * (Args.Y_MAX - Args.Y_MIN) * transformData.transforms.size)) - 1.0) / 2.0).toLong()

    println("radius for 1 expected hit: ${requiredRadius.formatWithUnderscores()}")
    if (requiredRadius > 1_875_000) println("WARNING: radius for 1 expected hit extends past the world border!")

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