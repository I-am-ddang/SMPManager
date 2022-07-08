package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.managers.GUIManager
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class CustomRecipeGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {
        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return
        val identify = ItemUtil.getStringPDC(item, "identify") ?: return

        when (identify) {
            "0" -> {
                val i = GUIManager.getInventory(InventoryName.RECIPE_TRACKER)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            else -> {
                return
            }
        }
    }

    override fun closeProcess(e: InventoryCloseEvent) {
        return
    }
}