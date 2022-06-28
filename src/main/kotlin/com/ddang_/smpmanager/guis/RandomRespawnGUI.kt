package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.managers.GUIManager
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.ItemUtil
import net.kyori.adventure.text.Component
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class RandomRespawnGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {
        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return
        val identify = ItemUtil.getStringPDC(item, "identify") ?: return

        when (identify) {
            "0" -> {
                Smpmanager.pluginConfig.randomRespawn = false
                val i = GUIManager.getInventory(InventoryName.RANDOM_RESPAWN)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "1" -> {
                Smpmanager.pluginConfig.randomRespawn = true
                val i = GUIManager.getInventory(InventoryName.RANDOM_RESPAWN)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "2" -> {
                p.closeInventory()
                val m = MemberManager.getMember(p.name) ?: return
                m.chatState = ChatState.RANDOM_RESPAWN_RANGE_SET
                p.sendMessage(
                    Component.text().append(
                        ComponentUtil.toText("  부활시 무작위 배치", Color.LIME.code),
                        ComponentUtil.toText(" 채팅창에 배치 범위를 적어주세요.", Color.WHITE.code)
                    ).build()
                )
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