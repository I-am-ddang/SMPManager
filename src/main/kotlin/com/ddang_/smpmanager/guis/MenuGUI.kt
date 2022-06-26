package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class MenuGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {
        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return
        val identify = ItemUtil.getStringPDC(item, "identify") ?: return
        return
    }

    override fun closeProcess(e: InventoryCloseEvent) {
        return
    }
}