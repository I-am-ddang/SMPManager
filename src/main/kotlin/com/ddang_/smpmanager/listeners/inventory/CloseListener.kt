package com.ddang_.smpmanager.listeners.inventory

import com.ddang_.smpmanager.guis.CustomGUIHolder
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent

class CloseListener: Listener {
    @EventHandler
    fun onInvClose(e: InventoryCloseEvent) {
        val holder = e.inventory.holder
        if (holder !is CustomGUIHolder) {
            return
        }
        holder.closeProcess(e)
    }
}