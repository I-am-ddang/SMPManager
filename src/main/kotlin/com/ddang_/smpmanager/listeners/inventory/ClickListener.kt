package com.ddang_.smpmanager.listeners.inventory

import com.ddang_.smpmanager.guis.CustomGUIHolder
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class ClickListener: Listener {
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val holder = e.inventory.holder
        if (holder !is CustomGUIHolder) {
            return
        }
        holder.clickProcess(e)
    }
}