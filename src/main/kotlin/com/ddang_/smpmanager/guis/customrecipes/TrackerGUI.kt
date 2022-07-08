package com.ddang_.smpmanager.guis.customrecipes

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.guis.CustomGUIHolder
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.ItemStack

class TrackerGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {

        val item = e.currentItem ?: return

        if (item.type == Material.LIGHT_GRAY_STAINED_GLASS_PANE) {
            e.isCancelled = true
        }

        val identify = ItemUtil.getStringPDC(item, "result") ?: return

        if (identify == "true") {
            e.isCancelled = true
        }

        return
    }

    override fun closeProcess(e: InventoryCloseEvent) {

        Smpmanager.pluginConfig.recipeCage.tracker.slot0 = e.inventory.getItem(3) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot1 = e.inventory.getItem(4) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot2 = e.inventory.getItem(5) ?: ItemStack(Material.AIR)

        Smpmanager.pluginConfig.recipeCage.tracker.slot3 = e.inventory.getItem(12) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot4 = e.inventory.getItem(13) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot5 = e.inventory.getItem(14) ?: ItemStack(Material.AIR)

        Smpmanager.pluginConfig.recipeCage.tracker.slot6 = e.inventory.getItem(21) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot7 = e.inventory.getItem(22) ?: ItemStack(Material.AIR)
        Smpmanager.pluginConfig.recipeCage.tracker.slot8 = e.inventory.getItem(23) ?: ItemStack(Material.AIR)

        return
    }
}