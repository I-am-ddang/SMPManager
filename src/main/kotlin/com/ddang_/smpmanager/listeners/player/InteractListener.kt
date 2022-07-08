package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager.Companion.rl
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class InteractListener: Listener {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        val p = e.player

        if (e.hand != EquipmentSlot.HAND) {
            return
        }

        if (e.action != Action.RIGHT_CLICK_BLOCK && e.action == Action.RIGHT_CLICK_AIR) {
            return
        }

        val item = p.inventory.itemInMainHand
        val pdc = ItemUtil.getStringPDC(item, "customItem") ?: return

        if (pdc != "2") {
            return
        }

        p.inventory.itemInMainHand.amount--

        val randomPlayer = Bukkit.getOnlinePlayers().random()
        val m = MemberManager.getMember(p.name) ?: return

        if (m.target != null) {
            p.sendMessage("§c  위치 추적기 §f이미 ${m.target?.name} 님을 추적하고 있습니다.")
            return
        }

        m.target = randomPlayer
        p.sendMessage("§5  위치 추적기 §f${randomPlayer.name} 님을 8분간 추적합니다.")

        (20L*60*8).rl {
            m.target = null
            p.sendMessage("§5  위치 추적기 §f더 이상 ${randomPlayer.name} 님을 추적하지 않습니다.")
        }
    }
}