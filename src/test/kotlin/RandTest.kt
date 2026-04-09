import lgbt.faith.Rand
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals
import java.util.Random

class RandTest {

    @Test
    fun testNextLongMatchesJavaRandom() {
        val seed = 123456789L

        val javaRand = Random(seed)
        val myRand = Rand(0).apply { setSeed(seed) }

        repeat(100000) {
            val expected = javaRand.nextLong()
            val actual = myRand.nextLong()

            assertEquals(expected, actual, "mismatch at iteration $it")
        }
    }
    @Test
    fun testNextFloatMatchesJavaRandom() {
        val seed = 123456789L

        val javaRand = Random(seed)
        val myRand = Rand(0).apply { setSeed(seed) }

        repeat(100000) {
            val expected = javaRand.nextFloat()
            val actual = myRand.nextFloat()

            assertEquals(expected, actual, "mismatch at iteration $it")
        }
    }
    @Test
    fun testNextIntMatchesJavaRandom() {
        val seed = 123456789L

        val javaRand = Random(seed)
        val myRand = Rand(0).apply { setSeed(seed) }

        repeat(100000) {
            val expected = javaRand.nextInt()
            val actual = myRand.nextInt()

            assertEquals(expected, actual, "mismatch at iteration $it")
        }
    }
    @Test
    fun testMultipleSeeds() {
        val seeds = listOf(
            0L,
            1L,
            -1L,
            Long.MAX_VALUE,
            Long.MIN_VALUE,
            123456789L,
            987654321L
        )

        for (seed in seeds) {
            val javaRand = Random(seed)
            val myRand = Rand(0).apply { setSeed(seed) }

            repeat(10000) {
                assertEquals(javaRand.nextLong(), myRand.nextLong())
            }
            repeat(10000) {
                assertEquals(javaRand.nextInt(), myRand.nextInt())
            }
            repeat(10000) {
                assertEquals(javaRand.nextFloat(), myRand.nextFloat())
            }
        }
    }
    @Test
    fun testDeterminism() {
        val r1 = Rand(0).apply { setSeed(42) }
        val r2 = Rand(0).apply { setSeed(42) }

        repeat(10000) {
            assertEquals(r1.nextLong(), r2.nextLong())
        }
    }

    @Test
    fun testIntegerNextFloat() {
        val rand1 = Rand()
        val rand2 = Rand()
        repeat(100_000_000) {
            val res1 = rand1.nextFloat() < 0.15f
            val res2 = rand2.next(24) < 2516583
            assertEquals(res1, res2, "$res1, $res2")
        }
    }

}