package com.ddang_.smpmanager.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.BlockFace

class LocationUtil {
    companion object {
        fun isSafeLocation(loc: Location): Boolean {
            val ground = loc.block.getRelative(BlockFace.DOWN)
            val down = loc.block
            val up = loc.block.getRelative(BlockFace.UP)

            if (!ground.type.isSolid || (!up.type.isSolid && up.type.name.contains("SIGN")) || (!down.type.isSolid && up.type.name.contains("SIGN"))) {
                return false
            }

            if (down.type == Material.LAVA || up.type == Material.LAVA || ground.type == Material.LAVA) {
                return false
            }

            if (ground.type.name.contains("FENCE")
                || ground.type.name.contains("DOOR")
                || ground.type.name.contains("GATE")
                || ground.type.name.contains("PLATE")
                || ground.type.name.contains("SIGN")
                || ground.type.name.contains("BUTTON")
                || ground.type.name.contains("BANNER")
                || ground.type.name.contains("BOAT")) {
                return false
            }

            return when (ground.type) {
                Material.WATER, Material.ANVIL, Material.BARRIER, Material.CACTUS,
                Material.END_PORTAL, Material.END_ROD, Material.FIRE, Material.FLOWER_POT,
                Material.LADDER, Material.LEVER, Material.TALL_GRASS, Material.PISTON_HEAD,
                Material.MOVING_PISTON, Material.TORCH, Material.WALL_TORCH, Material.TRIPWIRE,
                Material.COBWEB, Material.NETHER_PORTAL, Material.MAGMA_BLOCK -> {
                    false
                }
                else -> {
                    true
                }
            }
        }
    }
}