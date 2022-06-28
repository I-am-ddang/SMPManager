package com.ddang_.smpmanager.utils

import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.enums.WorldSettingOption
import com.ddang_.smpmanager.enums.WorldSettingOption.*
import com.ddang_.smpmanager.managers.WorldSettingOptionManager
import com.google.j2objc.annotations.WeakOuter
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.World

class ComponentUtil {
    companion object {
        fun toText(text: String, hex: String): Component {
            return Component.text(text, TextColor.fromHexString("#${hex}")).decoration(TextDecoration.ITALIC, false)
        }

        fun getWorldSettingWhether(world: World, worldSettingOption: WorldSettingOption): Component? {
            val wso = WorldSettingOptionManager.getWorldSettingOption(world.name) ?: return null
            return when (worldSettingOption) {
                COORDINATE -> {
                    when (wso.coordinateOption) {
                        true -> {
                            toText("활성화됨", Color.LIME.code)
                        }
                        false -> {
                            toText("비활성화됨", Color.RED.code)
                        }
                    }
                }
                CHAT -> {
                    when (wso.chatOption) {
                        true -> {
                            toText("활성화됨", Color.LIME.code)
                        }
                        false -> {
                            toText("비활성화됨", Color.RED.code)
                        }
                    }
                }
            }
        }
    }
}