package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.broad
import com.ddang_.smpmanager.managers.CustomItemManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class BlockPlaceListener: Listener {
    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val p = e.player
        val loc = e.block.location

        //엔더 드래곤의 가호
        if (!Smpmanager.pluginConfig.eventCage.enderDragon) {
            return
        }
        val eloc = Smpmanager.pluginConfig.eventCage.enderDragonLoc ?: return
        if (loc != eloc) {
            return
        }

        ("§5§l  엔더 드래곤의 가호 §f${p.name}님이 엔더 드래곤의 가호를 획득했습니다.").broad()

        //아이템 지급
        val item = CustomItemManager.getCustomItem(1) ?: return
        p.inventory.addItem(item.toItem())
    }
}