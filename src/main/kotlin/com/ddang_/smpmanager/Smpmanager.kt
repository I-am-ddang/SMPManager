package com.ddang_.smpmanager

import com.ddang_.smpmanager.commands.MenuCommand
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.ChatState.*
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.listeners.inventory.ClickListener
import com.ddang_.smpmanager.listeners.inventory.CloseListener
import com.ddang_.smpmanager.listeners.player.AsyncChatListener
import com.ddang_.smpmanager.listeners.player.RespawnListener
import com.ddang_.smpmanager.listeners.player.SwapItemListener
import com.ddang_.smpmanager.managers.MemberManager
import com.ddang_.smpmanager.managers.PluginConfigManager
import com.ddang_.smpmanager.objects.PluginConfig
import com.ddang_.smpmanager.utils.ComponentUtil
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import java.time.Duration

class Smpmanager : JavaPlugin() {
    companion object {
        lateinit var scheduler: BukkitScheduler
            private set
        lateinit var instance: Plugin
        lateinit var players: MutableCollection<out Player>
            private set
        lateinit var pluginConfig: PluginConfig
            private set

        fun Long.rl(run: Runnable) = scheduler.runTaskLater(instance, run, this)
        fun Long.rt(delay: Long = 1, run: Runnable) = scheduler.runTaskTimer(instance, run, delay, this)
        fun String.broad() = Bukkit.broadcastMessage(this)

    }

    private fun showTitlePerChatState() {
        (20L).rt {
            players.forEach {
                val m = MemberManager.getMember(it.name) ?: return@forEach
                when (m.chatState) {
                    NONE -> {
                        return@forEach
                    }
                    RANDOM_TELEPORT_RANGE_SET -> {
                        it.showTitle(Title.title(
                            Component.text().append(
                                ComponentUtil.toText("범위를 입력하세요", Color.LIME.code)
                            ).build(),
                            Component.text().append(
                                ComponentUtil.toText("숫자를 입력해야합니다.", Color.WHITE.code)
                            ).build(),
                            Title.Times.of(
                                Duration.ofSeconds(0),
                                Duration.ofSeconds(20),
                                Duration.ofSeconds(0)
                            )
                        ))
                    }
                    RANDOM_RESPAWN_RANGE_SET -> {
                        it.showTitle(Title.title(
                            Component.text().append(
                                ComponentUtil.toText("범위를 입력하세요", Color.LIME.code)
                            ).build(),
                            Component.text().append(
                                ComponentUtil.toText("숫자를 입력해야합니다.", Color.WHITE.code)
                            ).build(),
                            Title.Times.of(
                                Duration.ofSeconds(0),
                                Duration.ofSeconds(20),
                                Duration.ofSeconds(0)
                            )
                        ))
                    }
                }
            }
        }
    }

    private fun memberSave() {
        players.forEach {
            MemberManager.save(it)
        }
    }

    private fun memberSet() {
        players.forEach {
            MemberManager.set(it)
        }
    }

    private val events = arrayOf(
        SwapItemListener(), ClickListener(), CloseListener(), AsyncChatListener(), RespawnListener()
    )

    override fun onEnable() {
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler

        PluginConfigManager.firstSet()

        pluginConfig = PluginConfigManager.set()

        memberSet()

        showTitlePerChatState()

        //이벤트 등록
        server.pluginManager.apply { events.forEach { registerEvents(it, this@Smpmanager) } }

        //명령어 등록
        getCommand("smpmenu")?.setExecutor(MenuCommand())
    }

    override fun onDisable() {
        PluginConfigManager.save()

        memberSave()
    }
}