package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.objects.cages.EventCage
import com.ddang_.smpmanager.objects.PluginConfig
import com.ddang_.smpmanager.objects.cages.RecipeCage
import com.ddang_.smpmanager.objects.customrecipes.Tracker
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import java.io.File

class PluginConfigManager {
    companion object {
        fun set(): PluginConfig {

            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            val quickMenu = configData.getBoolean("Setting.QuickMenu")
            val randomRespawn = configData.getBoolean("Setting.RandomRespawn")
            val randomRespawnRange = configData.getInt("Setting.RandomRespawnRange")

            val recipeTracker0 = configData.getItemStack("Recipe.Tracker.0") ?: ItemStack(Material.AIR)
            val recipeTracker1 = configData.getItemStack("Recipe.Tracker.1") ?: ItemStack(Material.AIR)
            val recipeTracker2 = configData.getItemStack("Recipe.Tracker.2") ?: ItemStack(Material.AIR)
            val recipeTracker3 = configData.getItemStack("Recipe.Tracker.3") ?: ItemStack(Material.AIR)
            val recipeTracker4 = configData.getItemStack("Recipe.Tracker.4") ?: ItemStack(Material.AIR)
            val recipeTracker5 = configData.getItemStack("Recipe.Tracker.5") ?: ItemStack(Material.AIR)
            val recipeTracker6 = configData.getItemStack("Recipe.Tracker.6") ?: ItemStack(Material.AIR)
            val recipeTracker7 = configData.getItemStack("Recipe.Tracker.7") ?: ItemStack(Material.AIR)
            val recipeTracker8 = configData.getItemStack("Recipe.Tracker.8") ?: ItemStack(Material.AIR)

            return PluginConfig(
                quickMenu, randomRespawn, randomRespawnRange,
                EventCage(false, false, null),
                RecipeCage(
                    Tracker(recipeTracker0, recipeTracker1, recipeTracker2, recipeTracker3, recipeTracker4, recipeTracker5, recipeTracker6, recipeTracker7, recipeTracker8)
                )
            )
        }

        fun save() {
            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            configData["Setting.QuickMenu"] = Smpmanager.pluginConfig.quickMenu
            configData["Setting.RandomRespawn"] = Smpmanager.pluginConfig.randomRespawn
            configData["Setting.RandomRespawnRange"] = Smpmanager.pluginConfig.randomRespawnRange

            configData["Recipe.Tracker.0"] = Smpmanager.pluginConfig.recipeCage.tracker.slot0
            configData["Recipe.Tracker.1"] = Smpmanager.pluginConfig.recipeCage.tracker.slot1
            configData["Recipe.Tracker.2"] = Smpmanager.pluginConfig.recipeCage.tracker.slot2
            configData["Recipe.Tracker.3"] = Smpmanager.pluginConfig.recipeCage.tracker.slot3
            configData["Recipe.Tracker.4"] = Smpmanager.pluginConfig.recipeCage.tracker.slot4
            configData["Recipe.Tracker.5"] = Smpmanager.pluginConfig.recipeCage.tracker.slot5
            configData["Recipe.Tracker.6"] = Smpmanager.pluginConfig.recipeCage.tracker.slot6
            configData["Recipe.Tracker.7"] = Smpmanager.pluginConfig.recipeCage.tracker.slot7
            configData["Recipe.Tracker.8"] = Smpmanager.pluginConfig.recipeCage.tracker.slot8


            configData.save(file)
        }

        fun firstSet() {
            val file = File(Smpmanager.instance.dataFolder, "pluginConfig.yml")
            val configData = YamlConfiguration.loadConfiguration(file)

            nullSet(configData, "Setting.QuickMenu", true)
            nullSet(configData, "Setting.RandomRespawn", true)
            nullSet(configData, "Setting.RandomRespawnRange", 0)

            nullSet(configData, "Recipe.Tracker.0", ItemStack(Material.AIR))
            nullSet(configData, "Recipe.Tracker.1", ItemStack(Material.NETHERITE_INGOT))
            nullSet(configData, "Recipe.Tracker.2", ItemStack(Material.AIR))
            nullSet(configData, "Recipe.Tracker.3", ItemStack(Material.REDSTONE))
            nullSet(configData, "Recipe.Tracker.4", ItemStack(Material.COMPASS))
            nullSet(configData, "Recipe.Tracker.5", ItemStack(Material.ENDER_EYE))
            nullSet(configData, "Recipe.Tracker.6", ItemStack(Material.AIR))
            nullSet(configData, "Recipe.Tracker.7", ItemStack(Material.RABBIT_FOOT))
            nullSet(configData, "Recipe.Tracker.8", ItemStack(Material.AIR))

            configData.save(file)
        }

        private fun nullSet(yaml: YamlConfiguration, string: String, value: Any) {
            if (yaml.get(string) == null) {
                yaml[string] = value
            }
        }
    }
}