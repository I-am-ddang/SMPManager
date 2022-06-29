package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.rl
import com.ddang_.smpmanager.managers.TeleportManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent

class RespawnListener: Listener {
    @EventHandler
    fun onRespawn(e: PlayerRespawnEvent) {
        val p = e.player
        if (!Smpmanager.pluginConfig.randomRespawn) {
            return
        }
        (1L).rl {
            TeleportManager.randomTeleport(p, Smpmanager.pluginConfig.randomRespawnRange)
        }
    }
}