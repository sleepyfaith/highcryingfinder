package lgbt.faith

data class Transform(
    val mirror: BlockMirror,
    val rotation: BlockRotation,
    val offsets: List<BPos>
)


data class TransformData(
    val transforms: List<Transform>,
    val portalOffsets: List<BPos>,
    val flatOffsetsX: IntArray,
    val flatOffsetsY: IntArray,
    val flatOffsetsZ: IntArray,
    val transformStartIndices: IntArray
)



fun buildTransforms(): TransformData {
    val rp = RuinedPortal()

    val size = rp.STRUCTURE_SIZE[Args.PORTAL_TYPE] ?: error("invalid type")
    val pivot = BPos(size.x / 2, 0, size.z / 2)

    val portalOffsets = rp.getAllOffsets(Args.PORTAL_TYPE)
    val mirrors = listOf(BlockMirror.NONE, BlockMirror.FRONT_BACK)

    val transforms =
        portalOffsets
            .flatMap { offset ->
                mirrors.flatMap { mirror ->
                    BlockRotation.entries.map { rot ->
                        Triple(mirror, rot, offset.transform(mirror, rot, pivot))
                    }
                }
            }
            .groupBy(
                { it.first to it.second },
                { it.third }
            )
            .map { (k, v) ->
                Transform(k.first, k.second, v)
            }

    val flatOffsetsX = transforms.flatMap { it.offsets.map { p -> p.x } }.toIntArray()
    val flatOffsetsY = transforms.flatMap { it.offsets.map { p -> p.y } }.toIntArray()
    val flatOffsetsZ = transforms.flatMap { it.offsets.map { p -> p.z } }.toIntArray()

    val transformStartIndices = IntArray(transforms.size + 1).apply {
        var current = 0
        for (i in transforms.indices) {
            this[i] = current
            current += transforms[i].offsets.size
        }
        this[transforms.size] = current
    }

    return TransformData(
        transforms,
        portalOffsets,
        flatOffsetsX,
        flatOffsetsY,
        flatOffsetsZ,
        transformStartIndices
    )
}
