package com.ddang_.smpmanager

import com.ddang_.smpmanager.commands.MenuCommand
import com.ddang_.smpmanager.listeners.inventory.ClickListener
import com.ddang_.smpmanager.listeners.inventory.CloseListener
import com.ddang_.smpmanager.listeners.player.SwapItemListener
import com.ddang_.smpmanager.objects.PluginConfig
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

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

    private val events = arrayOf(
        SwapItemListener(), ClickListener(), CloseListener()
    )

    override fun onEnable() {
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler
        pluginConfig = PluginConfig(false)

        //이벤트 등록
        server.pluginManager.apply { events.forEach { registerEvents(it, this@Smpmanager) } }

        //명령어 등록
        getCommand("smpmenu")?.setExecutor(MenuCommand())
    }

    override fun onDisable() {
    }
}