package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.utils.LocationUtil
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Player

class TeleportManager {
    companion object {
        fun getRandomSpot(w: World, r: Int): Location {
            val x = (-r..r).random()
            val z = (-r..r).random()
            val y = w.getHighestBlockYAt(x, z)
            return Location(w, x.toDouble(), y.toDouble(), z.toDouble())
        }

        fun randomTeleport(p: Player, r: Int) {
            val random = getRandomSpot(p.world, r)
            if (LocationUtil.isSafeLocation(random)) {
                p.teleport(random)
            } else {
                randomTeleport(p, r)
            }
        }
    }
}