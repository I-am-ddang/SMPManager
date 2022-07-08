package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.broad
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.managers.TeleportManager
import com.ddang_.smpmanager.managers.WorldSettingOptionManager
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.LocationUtil
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.scheduler.BukkitRunnable

class AsyncChatListener: Listener {
    @EventHandler
    fun onAsyncChat(e: AsyncChatEvent) {
        val p = e.player

        if (p.hasPermission("smpmanager.chatselect")) {
            val m = MemberManager.getMember(p.name) ?: return
            when (m.chatState) {
                ChatState.RANDOM_TELEPORT_RANGE_SET -> {
                    e.isCancelled = true
                    val range = PlainTextComponentSerializer.plainText().serialize(e.message())
                    val rangeToInt = range.toIntOrNull() ?: kotlin.run {
                        p.sendMessage(
                            Component.text().append(
                                ComponentUtil.toText("  모든 플레이어 재배치", Color.RED.code),
                                ComponentUtil.toText(" 범위 설정을 위해 숫자를 입력해주세요.", Color.WHITE.code)
                            ).build()
                        )
                        m.chatState = ChatState.NONE
                        p.clearTitle()
                        return
                    }

                    m.chatState = ChatState.NONE
                    p.clearTitle()
                    object : BukkitRunnable() {
                        override fun run() {
                            Smpmanager.players.forEach {
                                TeleportManager.randomTeleport(it, rangeToInt)
                            }
                        }
                    }.runTask(Smpmanager.instance)
                }
                ChatState.RANDOM_RESPAWN_RANGE_SET -> {
                    e.isCancelled = true
                    val range = PlainTextComponentSerializer.plainText().serialize(e.message())
                    val rangeToInt = range.toIntOrNull() ?: kotlin.run {
                        p.sendMessage(
                            Component.text().append(
                                ComponentUtil.toText("  부활시 무작위 배치", Color.RED.code),
                                ComponentUtil.toText(" 범위 설정을 위해 숫자를 입력해주세요.", Color.WHITE.code)
                            ).build()
                        )
                        m.chatState = ChatState.NONE
                        p.clearTitle()
                        return
                    }
                    m.chatState = ChatState.NONE
                    p.clearTitle()
                    Smpmanager.pluginConfig.randomRespawnRange = rangeToInt
                }
                ChatState.EVENT_ENDER_DRAGON -> {
                    e.isCancelled = true
                    val range = PlainTextComponentSerializer.plainText().serialize(e.message())
                    val rangeToInt = range.toIntOrNull() ?: kotlin.run {
                        p.sendMessage(
                            Component.text().append(
                                ComponentUtil.toText("  엔더 드래곤의 가호", Color.RED.code),
                                ComponentUtil.toText(" 범위 설정을 위해 숫자를 입력해주세요.", Color.WHITE.code)
                            ).build()
                        )
                        m.chatState = ChatState.NONE
                        p.clearTitle()
                        return
                    }
                    m.chatState = ChatState.NONE
                    p.clearTitle()

                    //행사 시작
                    val w = Bukkit.getWorld("world") ?: return
                    Smpmanager.pluginConfig.eventCage.enderDragon = true
                    Smpmanager.pluginConfig.eventCage.enderDragonLoc = TeleportManager.getRandomSpot(w, rangeToInt)

                    val loc = Smpmanager.pluginConfig.eventCage.enderDragonLoc ?: return

                    ("§5§l  엔더 드래곤의 가호 §f드래곤 알을 오버 월드 x: ${loc.x} y: ${loc.y} z: ${loc.z} 에 설치해 권위적인 보상을 획득하세요! ").broad()
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
            p.sendMessage("§c현재 설정에 의해 해당 월드에서 채팅을 보낼 수 없습니다.")
        }
    }
}