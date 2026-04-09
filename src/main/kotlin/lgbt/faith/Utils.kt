package lgbt.faith

import kotlin.math.pow

fun binomial(n: Int, k: Int): Double {
    var res = 1.0
    for (i in 1..k) {
        res *= (n - (k - i)).toDouble() / i
    }
    return res
}

fun probExactly(n: Int, k: Int, p: Double): Double {
    return binomial(n, k) * p.pow(k) * (1 - p).pow(n - k)
}

fun probAtLeast(n: Int, k: Int, p: Double): Double {
    var sum = 0.0
    for (i in k..n) {
        sum += probExactly(n, i, p)
    }
    return sum
}

fun probabilityToOneIn(p: Double): Double {
    return 1.0 / p
}

fun formatLarge(n: Double): String {
    return when {
        n >= 1e24 -> "%.2f Sp".format(n / 1e24)
        n >= 1e21 -> "%.2f Sx".format(n / 1e21)
        n >= 1e18 -> "%.2f Qi".format(n / 1e18)
        n >= 1e15 -> "%.2f Qa".format(n / 1e15)
        n >= 1e12 -> "%.2fT".format(n / 1e12)
        n >= 1e9  -> "%.2fB".format(n / 1e9)
        n >= 1e6  -> "%.2fM".format(n / 1e6)
        n >= 1e3  -> "%.2fK".format(n / 1e3)
        else      -> "%.0f".format(n)
    }
}

fun formatChunks(n: Long): String {
    fun fmt(v: Double, suffix: String) =
        "%.2f".format(v).trimEnd('0').trimEnd('.') + suffix

    return when {
        n >= 1e15 -> fmt(n / 1e15, "q chunks")
        n >= 1e12 -> fmt(n / 1e12, "t chunks")
        n >= 1e9  -> fmt(n / 1e9, "b chunks")
        n >= 1e6  -> fmt(n / 1e6, "m chunks")
        n >= 1e3  -> fmt(n / 1e3, "k chunks")
        else      -> "%.0f chunks".format(n)
    }
}

fun chunkCount(radius: Int): Long {
    val axis = ((radius * 2)) + 1
    return axis.toLong() * axis
}