package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.broad
import com.ddang_.smpmanager.Smpmanager.Companion.rl
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.managers.CustomEventManager
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
                Smpmanager.pluginConfig.eventCage.magicApple = true
                CustomEventManager.oakLeafList.clear()
                ("§d§l  마법이 걸린 사과나무 §f3분 동안 참나무 나뭇잎을 캘 때 0.1% 확률로 마법이 걸린 황금사과가 나옵니다. ").broad()
                (20L*60*3).rl {
                    Smpmanager.pluginConfig.eventCage.magicApple = false
                    ("§d§l  마법이 걸린 사과나무 §f행사가 끝났습니다.").broad()
                    CustomEventManager.oakLeafList.clear()
                }
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