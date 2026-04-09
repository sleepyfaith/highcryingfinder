package lgbt.faith

enum class ObsidianType {
    FRAME,
    MINIMAL,
    EXTRA
}

class RuinedPortal {

    val regionSize = 40
    val seperation = 15
    val salt = 34222645
    val decorationSalt = 40005

    val offset = regionSize - seperation

    val SMALL_PORTALS = listOf("portal_1", "portal_2", "portal_3", "portal_4", "portal_5", "portal_6", "portal_7", "portal_8", "portal_9", "portal_10");
    val GIANT_PORTALS = listOf("giant_portal_1", "giant_portal_2", "giant_portal_3")
    val CHESTS: Map<String, BPos> = mapOf(
        "giant_portal_1" to BPos(4,3,3),
        "giant_portal_2" to BPos(9,1,9),
        "giant_portal_3" to BPos(9,2,3),

        "portal_1" to BPos(2,2,0),
        "portal_2" to BPos(8,2,6),
        "portal_3" to BPos(3,3,6),
        "portal_4" to BPos(3,3,2),
        "portal_5" to BPos(4,3,2),
        "portal_6" to BPos(1,1,4),
        "portal_7" to BPos(0,1,2),
        "portal_8" to BPos(4,4,2),
        "portal_9" to BPos(4,1,0),
        "portal_10" to BPos(2,1,7)
    )

    val STRUCTURE_SIZE: Map<String, BPos> = mapOf(
        "giant_portal_1" to BPos(11,17,16),
        "giant_portal_2" to BPos(11,16,16),
        "giant_portal_3" to BPos(16,16,16),

        "portal_1" to BPos(6,10,6),
        "portal_2" to BPos(9,12,9),
        "portal_3" to BPos(8,9,9),
        "portal_4" to BPos(8,9,9),
        "portal_5" to BPos(10,10,7),
        "portal_6" to BPos(5,7,7),
        "portal_7" to BPos(9,7,9),
        "portal_8" to BPos(14,9,9),
        "portal_9" to BPos(10,8,9),
        "portal_10" to BPos(12,8,10)
    )

    val GROUPED_OBSIDIAN: Map<String, Map<ObsidianType, List<BPos>>> = mapOf(
        "giant_portal_1" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(5,3,4), BPos(5,3,5), BPos(5,3,6), BPos(5,3,7), BPos(5,3,8), BPos(5,3,11),
                BPos(5,4,4), BPos(5,7,11), BPos(5,8,4), BPos(5,8,11),
                BPos(5,9,4), BPos(5,9,11), BPos(5,10,4), BPos(5,11,4),
                BPos(5,12,4), BPos(5,12,5), BPos(5,12,6), BPos(5,12,7)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(5,3,9), BPos(5,3,10),
                BPos(5,4,11), BPos(5,5,11), BPos(5,6,11)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(8,1,12), BPos(9,1,9), BPos(9,1,12), BPos(10,1,8),
                BPos(7,2,1), BPos(8,2,1), BPos(9,2,9), BPos(9,2,12)
            )
        ),

        "giant_portal_2" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(5,3,4), BPos(5,3,5), BPos(5,3,6), BPos(5,3,7), BPos(5,3,8), BPos(5,3,11),
                BPos(5,4,4), BPos(5,7,11),
                BPos(5,8,11), BPos(5,9,11),
                BPos(5,10,4), BPos(5,10,11),
                BPos(5,11,4), BPos(5,11,11),
                BPos(5,12,4), BPos(5,12,7), BPos(5,12,8), BPos(5,12,11)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(5,3,9), BPos(5,3,10),
                BPos(5,4,11), BPos(5,5,11), BPos(5,6,11)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(3,2,5), BPos(4,2,2),
                BPos(7,2,1), BPos(8,2,1),
                BPos(3,3,5), BPos(3,4,5)
            )
        ),

        "giant_portal_3" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(5,3,4), BPos(5,3,5), BPos(5,3,6), BPos(5,3,7), BPos(5,3,8), BPos(5,3,11),
                BPos(5,4,4), BPos(5,7,11),
                BPos(5,8,11), BPos(5,9,11),
                BPos(5,12,9)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(5,3,9), BPos(5,3,10),
                BPos(5,4,11), BPos(5,5,11), BPos(5,6,11)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(3,1,1), BPos(9,1,9),
                BPos(3,2,1), BPos(9,2,9),
                BPos(10,2,4), BPos(10,2,5),
                BPos(3,3,1), BPos(9,3,9), BPos(9,4,9)
            )
        ),
        "portal_1" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(3,2,1), BPos(3,2,4), BPos(3,6,1)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(3,2,2), BPos(3,2,3), BPos(3,3,1), BPos(3,3,4),
                BPos(3,4,1), BPos(3,5,1), BPos(3,6,2), BPos(3,6,3)
            )
        ),

        "portal_2" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(5,4,2), BPos(5,8,2), BPos(5,8,5)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(5,5,2), BPos(5,6,2), BPos(5,7,2),
                BPos(5,7,5), BPos(5,8,3), BPos(5,8,4)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(3,1,6), BPos(3,2,6)
            )
        ),

        "portal_3" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(4,3,2), BPos(4,3,5), BPos(4,7,5)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(4,3,3), BPos(4,3,4),
                BPos(4,4,5), BPos(4,5,5),
                BPos(4,6,5), BPos(4,7,4)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(6,2,2), BPos(6,3,3)
            )
        ),

        "portal_4" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(4,3,2), BPos(4,3,5)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(4,3,3), BPos(4,3,4),
                BPos(4,4,2), BPos(4,4,5),
                BPos(4,5,2), BPos(4,5,5),
                BPos(4,6,2)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(7,1,6), BPos(6,2,4)
            )
        ),

        "portal_5" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(2,3,1), BPos(2,3,4), BPos(2,7,4), BPos(2,8,4)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(2,3,2), BPos(2,3,3),
                BPos(2,4,4), BPos(2,5,4), BPos(2,6,4)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(5,3,1), BPos(6,3,1), BPos(7,3,1),
                BPos(8,3,1), BPos(8,3,2), BPos(8,3,3)
            )
        ),

        "portal_6" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(2,1,0), BPos(2,1,4), BPos(2,5,0), BPos(2,5,4)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(2,1,1), BPos(2,1,2), BPos(2,1,3),
                BPos(2,2,0), BPos(2,2,4),
                BPos(2,3,0), BPos(2,3,4),
                BPos(2,4,0), BPos(2,4,4),
                BPos(2,5,1), BPos(2,5,3)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(4,1,3)
            )
        ),

        "portal_7" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(3,0,2), BPos(3,4,2)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(3,0,3), BPos(3,0,4),
                BPos(3,1,2), BPos(3,1,5),
                BPos(3,2,2), BPos(3,2,5),
                BPos(3,3,2),
                BPos(3,4,3), BPos(3,4,4)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(5,1,6)
            )
        ),

        "portal_8" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(5,3,2), BPos(5,3,6),
                BPos(5,7,2), BPos(5,7,6),
                BPos(5,8,6)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(5,3,3), BPos(5,3,4), BPos(5,3,5),
                BPos(5,4,2), BPos(5,4,6),
                BPos(5,5,2), BPos(5,5,6),
                BPos(5,6,2), BPos(5,6,6)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(9,1,3), BPos(9,1,4), BPos(9,1,5)
            )
        ),

        "portal_9" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(4,1,3), BPos(4,1,6), BPos(4,5,6)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(4,1,4), BPos(4,1,5),
                BPos(4,2,3), BPos(4,2,6),
                BPos(4,3,6), BPos(4,4,6),
                BPos(4,5,4), BPos(4,5,5)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(7,1,3)
            )
        ),

        "portal_10" to mapOf(
            ObsidianType.FRAME to listOf(
                BPos(3,1,3), BPos(3,1,6)
            ),
            ObsidianType.MINIMAL to listOf(
                BPos(3,1,4), BPos(3,1,5), BPos(3,2,3)
            ),
            ObsidianType.EXTRA to listOf(
                BPos(5,1,6), BPos(6,1,3), BPos(7,1,3),
                BPos(7,1,6), BPos(8,1,3),
                BPos(8,1,4), BPos(8,1,5), BPos(8,1,6)
            )
        )
    )

    fun getFrameOffsets(type: String): List<BPos> {
        return GROUPED_OBSIDIAN[type]
            ?.get(ObsidianType.FRAME)
            ?: emptyList()
    }

    fun getMinimalOffsets(type: String): List<BPos> {
        return GROUPED_OBSIDIAN[type]
            ?.get(ObsidianType.MINIMAL)
            ?: emptyList()
    }

    fun getExtraOffsets(type: String): List<BPos> {
        return GROUPED_OBSIDIAN[type]
            ?.get(ObsidianType.EXTRA)
            ?: emptyList()
    }
    fun getPortalOffsets(type: String): List<BPos> {
        val map = GROUPED_OBSIDIAN[type] ?: return emptyList()

        return buildList {
            addAll(map[ObsidianType.FRAME] ?: emptyList())
            addAll(map[ObsidianType.MINIMAL] ?: emptyList())
        }
    }
    fun getAllOffsets(type: String): List<BPos> {
        return GROUPED_OBSIDIAN[type]
            ?.values
            ?.flatten()
            ?: emptyList()
    }



}