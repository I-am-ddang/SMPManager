package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.objects.WorldSettingOption
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class WorldSettingOptionManager {
    companion object {
        val worldSettingOptionList = arrayListOf<WorldSettingOption>()

        fun getWorldSettingOption(name: String) = worldSettingOptionList.find { it.world.name == name }

        fun set(world: World) {
            val file = File(Smpmanager.instance.dataFolder, "${File.separator}WorldData${File.separator}${world.name}.yml")
            val worldData = YamlConfiguration.loadConfiguration(file)

            val coordinate = worldData.getBoolean("Option.Coordinate")
            val chat = worldData.getBoolean("Option.Chat")

            WorldSettingOption(world, coordinate, chat)

        }

        fun save(world: World) {
            val file = File(Smpmanager.instance.dataFolder, "${File.separator}WorldData${File.separator}${world.name}.yml")
            val worldData = YamlConfiguration.loadConfiguration(file)

            val worldSettingOption = getWorldSettingOption(world.name) ?: return

            worldData["Option.Coordinate"] = worldSettingOption.coordinateOption
            worldData["Option.Chat"] = worldSettingOption.chatOption

            worldData.save(file)
        }
    }
}