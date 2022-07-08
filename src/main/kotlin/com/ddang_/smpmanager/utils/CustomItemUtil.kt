package com.ddang_.smpmanager.utils

import org.bukkit.entity.Player

class CustomItemUtil {
    companion object {
        fun doesHaveCustomItem(p: Player, customItemId: Int): Boolean {
            val contents = p.inventory.contents ?: return false
            contents.forEach {
                if (it == null) {
                    return@forEach
                }
                val pdc = ItemUtil.getStringPDC(it, "customItem") ?: return@forEach
                if (pdc.toInt() != customItemId) {
                    return@forEach
                }
                return true
            }
            return false
        }
    }
}