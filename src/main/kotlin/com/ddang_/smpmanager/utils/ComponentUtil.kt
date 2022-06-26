package com.ddang_.smpmanager.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration

class ComponentUtil {
    companion object {
        fun toText(text: String, hex: String): Component {
            return Component.text(text, TextColor.fromHexString("#${hex}")).decoration(TextDecoration.ITALIC, false)
        }
    }
}