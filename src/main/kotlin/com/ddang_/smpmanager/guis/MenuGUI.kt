package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.ItemUtil
import net.kyori.adventure.text.Component
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
            }
            "1" -> {

            }
            "2" -> {

            }
            "3" -> {

            }
            "4" -> {

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