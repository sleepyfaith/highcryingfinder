package lgbt.faith

import kotlin.math.sqrt


enum class BlockMirror(val orientation: BPos) {
    NONE(BPos(0, 0, 0)),
    LEFT_RIGHT(BPos(0, 0, 1)),
    FRONT_BACK(BPos(1, 0, 0));

    fun mirror(pos: BPos): BPos {
        return when (this) {
            LEFT_RIGHT -> BPos(pos.x, pos.y, -pos.z)
            FRONT_BACK -> BPos(-pos.x, pos.y, pos.z)
            else -> BPos(pos.x, pos.y, pos.z)
        }
    }

}
enum class BlockRotation(val direction: BlockDirection) {
    NONE(BlockDirection.NORTH),
    CLOCKWISE_90(BlockDirection.EAST),
    CLOCKWISE_180(BlockDirection.SOUTH),
    CLOCKWISE_270(BlockDirection.WEST);


    fun rotate(origin: BPos, pivot: BPos): BPos {
        val px: Int = pivot.x
        val pz: Int = pivot.z
        return when (this) {
            CLOCKWISE_90 -> BPos(px + pz - origin.z, origin.y, pz - px + origin.x)
            CLOCKWISE_180 -> BPos(px + px - origin.x, origin.y, pz + pz - origin.z)
            CLOCKWISE_270 -> BPos(px - pz + origin.z, origin.y, px + pz - origin.x)

            else -> origin
        }

    }
}
enum class BlockDirection(val axis: Axis, val vec: BPos) {
    DOWN(Axis.Y, BPos(0, -1, 0)),
    UP(Axis.Y, BPos(0, 1, 0)),
    NORTH(Axis.Z, BPos(0, 0, -1)), // NONE
    SOUTH(Axis.Z, BPos(0, 0, 1)),  // CLOCKWISE_180
    WEST(Axis.X, BPos(-1, 0, 0)),  // CLOCKWISE_270
    EAST(Axis.X, BPos(1, 0, 0))    // CLOCKWISE_90
}
enum class Axis {
    X, Y, Z;

    fun get2DRotated(): Axis {
        return when (this) {
            X -> Z
            Z -> X
            else -> Axis.Y
        }
    }
}
data class BPos(val x: Int = 0, val y: Int = 0, val z: Int = 0) {

    fun transform(mirror: BlockMirror, rotation: BlockRotation, pivot: BPos): BPos {
        return rotation.rotate(mirror.mirror(this), pivot)
    }

    fun getStrongholdRing(): Int? {
        val distance = sqrt((x.toDouble() * x) + (z.toDouble() * z))

        return when (distance) {
            in 1280.0..2816.0 -> 1
            in 4352.0..5888.0 -> 2
            in 7424.0..8960.0 -> 3
            in 10496.0..12032.0 -> 4
            in 13568.0..15104.0 -> 5
            in 16640.0..18176.0 -> 6
            in 19712.0..21248.0 -> 7
            in 22784.0..24320.0 -> 8
            else -> null
        }
    }

    fun isInStrongholdRing(): Boolean {
        return getStrongholdRing() != null
    }
}

data class CPos(val x: Int, val z: Int) {
    fun toRegionPos(regionSize: Int): RPos {
        val x: Int = if (x < 0) x - regionSize + 1 else x
        val z: Int = if (z < 0) z - regionSize + 1 else z
        return RPos(x / regionSize, z / regionSize, regionSize)
    }
}

data class RPos(val x: Int, val z: Int, val regionSize: Int)
