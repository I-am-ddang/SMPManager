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
            val randomRespawn = configData.getBoolean("Setting.RandomRespawn")
            val randomRespawnRange = configData.getInt("Setting.RandomRespawnRange")

            return PluginConfig(quickMenu, randomRespawn, randomRespawnRange)
        }

        fun save() {
            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            configData["Setting.QuickMenu"] = Smpmanager.pluginConfig.quickMenu
            configData["Setting.RandomRespawn"] = Smpmanager.pluginConfig.randomRespawn
            configData["Setting.RandomRespawnRange"] = Smpmanager.pluginConfig.randomRespawnRange

            configData.save(file)
        }

        fun firstSet() {
            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            nullSet(configData, "Setting.QuickMenu", true)
            nullSet(configData, "Setting.RandomRespawn", true)
            nullSet(configData, "Setting.RandomRespawnRange", 0)

            configData.save(file)
        }

        private fun nullSet(yaml: YamlConfiguration, string: String, value: Any) {
            if (yaml.get(string) == null) {
                yaml[string] = value
            }
        }
    }
}