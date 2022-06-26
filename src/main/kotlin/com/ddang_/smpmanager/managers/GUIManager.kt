package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.guis.MenuGUI
import com.ddang_.smpmanager.utils.ComponentUtil
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

class GUIManager {
    companion object {
        fun getInventory(inventoryName: InventoryName): Inventory {
            when (inventoryName) {
                InventoryName.MENU -> {
                    val i = Bukkit.createInventory(MenuGUI(), 9, ComponentUtil.toText(
                        "메뉴", "000000"
                    ))

                    return i
                }
            }
        }
    }
}