package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.objects.CustomItem
import com.ddang_.smpmanager.utils.ComponentUtil
import org.bukkit.Material

class CustomItemManager {

    companion object {

        val customItemList = arrayListOf<CustomItem>()

        fun getCustomItem(id: Int) = customItemList.find { it.id == id }

        fun set() {
            CustomItem(
                1,
                ComponentUtil.toText("엔더 드래곤의 가호", Color.DARK_PURPLE.code),
                Material.FLOWER_BANNER_PATTERN,
                arrayListOf(
                    ComponentUtil.toText("", Color.WHITE.code),
                    ComponentUtil.toText("보관함에 들고 있으면 저항2 효과와", Color.WHITE.code),
                    ComponentUtil.toText("느린 낙하 1 효과를 받습니다.", Color.WHITE.code),
                    ComponentUtil.toText("또한 웅크리고 점프할시 공중에서 웅크리는 동안.", Color.WHITE.code),
                    ComponentUtil.toText("공중 부양 효과를 받습니다.", Color.WHITE.code),
                )
            )
        }
    }
}