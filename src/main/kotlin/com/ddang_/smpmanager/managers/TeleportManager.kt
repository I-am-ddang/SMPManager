package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.utils.LocationUtil
import org.bukkit.Location
import org.bukkit.entity.Player

class TeleportManager {
    companion object {
        fun getRandomSpot(p: Player, r: Int): Location {
            val x = (-r..r).random()
            val z = (-r..r).random()
            val y = p.world.getHighestBlockYAt(x, z)
            return Location(p.world, x.toDouble(), y.toDouble(), z.toDouble())
        }

        fun randomTeleport(p: Player, r: Int) {
            val random = getRandomSpot(p, r)
            if (LocationUtil.isSafeLocation(random)) {
                p.teleport(random)
            } else {
                randomTeleport(p, r)
            }
        }
    }
}