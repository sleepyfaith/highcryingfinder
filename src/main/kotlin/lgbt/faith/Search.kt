package lgbt.faith

fun findCoords(startX: Int, endX: Int, transformData: TransformData) {
    val rand = Rand()
    val numTransforms = transformData.transforms.size

    for (cx in startX..endX) {

        for (cz in -Args.SEARCH_RADIUS..Args.SEARCH_RADIUS) {

            for (y in Args.Y_MIN .. Args.Y_MAX) {
                for (tIdx in 0 until numTransforms) {

                    val start = transformData.transformStartIndices[tIdx]
                    val end = transformData.transformStartIndices[tIdx + 1]
                    val totalOffsets = end - start

                    var cryingCount = 0

                    for (i in 0 until totalOffsets) {
                        val offIdx = start + i

                        rand.setPositionSeed(
                            (cx * 16) + transformData.flatOffsetsX[offIdx],
                            y + transformData.flatOffsetsY[offIdx],
                            (cz * 16) + transformData.flatOffsetsZ[offIdx]
                        )

                        if (rand.next(24) < 2516583) {
                            cryingCount++
                        }

                        if (cryingCount >= Args.MIN_CRYING) break

                        val remaining = totalOffsets - i - 1
                        if (cryingCount + remaining < Args.MIN_CRYING) break
                    }

                    if (cryingCount >= Args.MIN_CRYING) {
                        val x = cx * 16
                        val z = cz * 16

                        val t = transformData.transforms[tIdx]

                        val line = "Triple(BPos($x,$y,$z), BlockRotation.${t.rotation}, BlockMirror.${t.mirror}),"

                        println(line)
                        RESULTS_FILE.appendText(line)
                    }
                }
            }
        }
    }
}