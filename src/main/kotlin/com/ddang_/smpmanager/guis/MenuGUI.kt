package com.ddang_.smpmanager.guis

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

class MenuGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {
        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return
        val identify = ItemUtil.getStringPDC(item, "identify") ?: return

        when (identify) {
            "0" -> {
                p.closeInventory()
                val m = MemberManager.getMember(p.name) ?: return
                m.chatState = ChatState.RANDOM_TELEPORT_RANGE_SET
                p.sendMessage(
                    Component.text().append(
                        ComponentUtil.toText("  모든 플레이어 재배치", Color.LIME.code),
                        ComponentUtil.toText(" 채팅창에 재배치 범위를 적어주세요.", Color.WHITE.code)
                    ).build()
                )
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "1" -> {
                val i = GUIManager.getInventory(InventoryName.CUSTOM_RECIPE)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "2" -> {
                val i = GUIManager.getInventory(InventoryName.RANDOM_RESPAWN)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "3" -> {
                val i = GUIManager.getInventory(InventoryName.WORLD_SETTING)
                p.openInventory(i)
                p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
            }
            "4" -> {
                val i = GUIManager.getInventory(InventoryName.CUSTOM_EVENT)
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