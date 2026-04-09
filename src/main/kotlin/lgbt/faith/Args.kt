package lgbt.faith

import kotlin.system.exitProcess

object Args {

    private lateinit var cli: Map<String, String>

    fun init(raw: Array<String>) {
        if (raw.contains("--help")) {
            printHelp()
            exitProcess(0)
        }

        cli = raw.mapNotNull {
            val parts = it.split("=")
            if (parts.size == 2) parts[0] to parts[1] else null
        }.toMap()
    }

    private fun get(key: String): String? =
        cli[key] ?: System.getProperty(key)

    val PORTAL_TYPE: String get() =
        get("portalType") ?: "portal_1"

    val SEARCH_RADIUS: Int get() =
        get("searchRadius")?.toInt() ?: 10000

    val Y_MIN: Int get() =
        get("yMin")?.toInt() ?: 15

    val Y_MAX: Int get() =
        get("yMax")?.toInt() ?: 85

    val THREADS: Int get() =
        get("threads")?.toInt() ?: 4

    val MIN_CRYING: Int get() =
        get("minCrying")?.toInt() ?: 11
}

val jarName: String by lazy {
    val path = object {}.javaClass.protectionDomain
        .codeSource
        ?.location
        ?.toURI()
        ?.path

    path?.substringAfterLast('/') ?: "highcryingfinder.jar"
}

fun printHelp() {
    println(
        """
        usage: java -jar $jarName [options]

        options:
          --help                show this help message
          portalType=<string>   portal type (default: portal_1)
          searchRadius=<int>    chunk radius (default: 10000)
          yMin=<int>            Min Y level (default: 15)
          yMax=<int>            Max Y level (default: 85)
          threads=<int>         Thread count (default: 4)
          minCrying=<int>       Minimum crying obsidian (default: 10)

        Example:
          java -jar $jarName.jar searchRadius=100000 threads=32
        """.trimIndent()
    )
}