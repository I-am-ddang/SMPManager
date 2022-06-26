package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.objects.PluginConfig
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class PluginConfigManager {
    companion object {
        fun set(): PluginConfig {

            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            val quickMenu = configData.getBoolean("Setting.QuickMenu")

            return PluginConfig(quickMenu)
        }

        fun save() {
            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            configData["Setting.QuickMenu"] = Smpmanager.pluginConfig.quickMenu

            configData.save(file)
        }
    }
}