package lgbt.faith

class Rand(var seed: Long = 0) {

    private val multiplier = 0x5DEECE66DL
    private val addend = 0xBL
    private val mask = (1L shl 48) - 1

    fun next(bits: Int): Int {
        seed = (seed * multiplier + addend) and mask
        return (seed ushr (48-bits)).toInt()
    }
    fun nextFloat(): Float {
        return next(24) / (1 shl 24).toFloat()
    }
    fun nextInt(): Int {
        return next(32)
    }
    fun nextLong(): Long {
        return (next(32).toLong() shl 32) + next(32).toLong()
    }

    fun setSeed(newSeed: Long): Long {
        seed = (newSeed xor multiplier) and mask
        return seed
    }
    fun setPositionSeed(x: Int, y: Int, z: Int): Long {
        var i = (x * 3129871).toLong() xor z.toLong() * 116129781L xor y.toLong()
        i = i * i * 42317861L + i * 11L

        val seedVal = (i shr 16)
        setSeed(seedVal)

        return seedVal and mask
    }

    fun nextInt(bound: Int): Int {
        require(bound > 0)
        if ((bound and -bound) == bound) {
            // power of two
            return ((bound.toLong() * next(31)) shr 31).toInt()
        }
        var bits: Int
        var value: Int
        do {
            bits = next(31)
            value = bits % bound
        } while (bits - value + (bound - 1) < 0)

        return value
    }


    fun setPositionSeed(bPos: BPos): Long {
        return setPositionSeed(bPos.x, bPos.y, bPos.z)
    }
    fun setRegionSeed(worldSeed: Long, regionX: Int, regionZ: Int, salt: Int): Long {
        val seedVal: Long = regionX.toLong() * 341873128712L + regionZ.toLong() * 132897987541L + worldSeed + salt.toLong()
        setSeed(seedVal)
        return seedVal and mask
    }
    fun setCarverSeed(worldSeed: Long, chunkX: Int, chunkZ: Int): Long {
        setSeed(worldSeed)
        val a = nextLong()
        val b = nextLong()
        val seedVal = chunkX * a xor chunkZ * b xor worldSeed
        setSeed(seedVal)
        return seedVal and  mask
    }
}