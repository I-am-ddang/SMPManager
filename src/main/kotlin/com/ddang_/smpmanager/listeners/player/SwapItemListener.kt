package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.managers.GUIManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerSwapHandItemsEvent

class SwapItemListener: Listener {
    @EventHandler
    fun onSwapItem(e: PlayerSwapHandItemsEvent) {
        val p = e.player

        //콘피그 옵션 비활성화면 리턴
        if (!Smpmanager.pluginConfig.quickMenu) {
            return
        }

        //권한 없으면 리턴
        if (!p.hasPermission("smpmanager.smpmenu")) {
            return
        }

        if (!p.isSneaking) {
            return
        }

        val i = GUIManager.getInventory(InventoryName.MENU)
        p.openInventory(i)
    }
}