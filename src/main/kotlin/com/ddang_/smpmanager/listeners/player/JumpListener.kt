package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.objects.CustomItem
import com.ddang_.smpmanager.utils.CustomItemUtil
import com.destroystokyo.paper.event.player.PlayerJumpEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class JumpListener: Listener {
    @EventHandler
    fun onJump(e: PlayerJumpEvent) {
        val p = e.player
        if (!CustomItemUtil.doesHaveCustomItem(p, 1)) {
            return
        }

    }
}