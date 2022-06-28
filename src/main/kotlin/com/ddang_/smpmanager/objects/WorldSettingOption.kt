package com.ddang_.smpmanager.objects

import com.ddang_.smpmanager.managers.WorldSettingOptionManager
import org.bukkit.World

class WorldSettingOption (val world: World,
                          var coordinateOption: Boolean,
                          var chatOption: Boolean) {
    init {
        WorldSettingOptionManager.worldSettingOptionList.add(this)
    }
}