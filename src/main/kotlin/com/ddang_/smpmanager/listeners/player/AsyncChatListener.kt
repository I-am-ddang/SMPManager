package com.ddang_.smpmanager.listeners.player

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class AsyncChatListener: Listener {
    @EventHandler
    fun onAsyncChat(e: AsyncChatEvent) {
        val p = e.player

    }
}