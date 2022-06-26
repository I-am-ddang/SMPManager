package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.utils.ComponentUtil
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class CustomGUIHolder: InventoryHolder {
    override fun getInventory(): Inventory {
        return Bukkit.createInventory(null, 9, ComponentUtil.toText("", ""))
    }

    abstract fun clickProcess(e: InventoryClickEvent)

    abstract fun closeProcess(e: InventoryCloseEvent)
}