package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.managers.TeleportManager
import com.ddang_.smpmanager.managers.WorldSettingOptionManager
import com.ddang_.smpmanager.utils.ComponentUtil
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class AsyncChatListener: Listener {
    @EventHandler
    fun onAsyncChat(e: AsyncChatEvent) {
        val p = e.player

        if (p.isOp) {
            val m = MemberManager.getMember(p.name) ?: return
            when (m.chatState) {
                ChatState.RANDOM_TELEPORT_RANGE_SET -> {
                    val range = PlainTextComponentSerializer.plainText().serialize(e.message())
                    val rangeToInt = range.toIntOrNull() ?: kotlin.run {
                        p.sendMessage(
                            Component.text().append(
                                ComponentUtil.toText("  모든 플레이어 재배치", Color.RED.code),
                                ComponentUtil.toText(" 범위 설정을 위해 숫자를 입력해주세요.", Color.WHITE.code)
                            ).build()
                        )
                        m.chatState = ChatState.NONE
                        return
                    }
                    TeleportManager.randomTeleport(p, rangeToInt)
                }
                ChatState.RANDOM_RESPAWN_RANGE_SET -> {
                    val range = PlainTextComponentSerializer.plainText().serialize(e.message())
                    val rangeToInt = range.toIntOrNull() ?: kotlin.run {
                        p.sendMessage(
                            Component.text().append(
                                ComponentUtil.toText("  부활시 무작위 배치", Color.RED.code),
                                ComponentUtil.toText(" 범위 설정을 위해 숫자를 입력해주세요.", Color.WHITE.code)
                            ).build()
                        )
                        m.chatState = ChatState.NONE
                        return
                    }
                    Smpmanager.pluginConfig.randomRespawnRange = rangeToInt
                }
                else -> {
                    return
                }
            }
            return
        }

        val world = p.world
        val wso = WorldSettingOptionManager.getWorldSettingOption(world.name) ?: return
        if (!wso.chatOption) {
            e.isCancelled = true
        }
    }
}