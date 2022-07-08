package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.ItemUtil
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class CustomEventGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {
        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return
        val identify = ItemUtil.getStringPDC(item, "identify") ?: return

        when (identify) {
            "0" -> {
                val m = MemberManager.getMember(p.name) ?: return
                m.chatState = ChatState.EVENT_ENDER_DRAGON
                p.sendMessage(
                    Component.text().append(
                        ComponentUtil.toText("  엔더 드래곤의 가호", Color.DARK_PURPLE.code),
                        ComponentUtil.toText(" 채팅창에 엔더 드래곤 알을 설치해야 할 범위를 적어주세요.", Color.WHITE.code)
                    ).build()
                )
            }
            "1" -> {

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