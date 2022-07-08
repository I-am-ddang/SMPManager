package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.rt
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.objects.CustomItem
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.CustomItemUtil
import org.bukkit.Material
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class CustomItemManager {

    companion object {

        val customItemList = arrayListOf<CustomItem>()

        fun getCustomItem(id: Int) = customItemList.find { it.id == id }

        fun runAbility() {
            (1L).rt {
                Smpmanager.players.forEach {
                    if (!it.isSneaking) {
                        return@forEach
                    }

                    if (!CustomItemUtil.doesHaveCustomItem(it, 1)) {
                        return@forEach
                    }

                    it.addPotionEffect(PotionEffect(
                        PotionEffectType.LEVITATION, 2, 0
                    ))
                }
            }

            (20L).rt {
                Smpmanager.players.forEach {

                    if (!CustomItemUtil.doesHaveCustomItem(it, 1)) {
                        return@forEach
                    }

                    it.addPotionEffect(PotionEffect(
                        PotionEffectType.DAMAGE_RESISTANCE, 20, 1
                    ))
                    it.addPotionEffect(PotionEffect(
                        PotionEffectType.SLOW_FALLING, 20, 0
                    ))
                }
            }
        }

        fun set() {
            CustomItem(
                1,
                ComponentUtil.toText("엔더 드래곤의 가호", Color.DARK_PURPLE.code),
                Material.FLOWER_BANNER_PATTERN,
                arrayListOf(
                    ComponentUtil.toText("", Color.WHITE.code),
                    ComponentUtil.toText("보관함에 들고 있으면 저항2 효과와", Color.WHITE.code),
                    ComponentUtil.toText("느린 낙하 1 효과를 받습니다.", Color.WHITE.code),
                    ComponentUtil.toText("또한 점프할시 공중에서 웅크리는 동안.", Color.WHITE.code),
                    ComponentUtil.toText("공중 부양 효과를 받습니다.", Color.WHITE.code),
                )
            )
            CustomItem(
                2,
                ComponentUtil.toText("위치 추적기", Color.DARK_PURPLE.code),
                Material.COMPASS,
                arrayListOf(
                    ComponentUtil.toText("", Color.WHITE.code),
                    ComponentUtil.toText("들고 우클릭을 하면 이 아이템을 소모해", Color.WHITE.code),
                    ComponentUtil.toText("8분 동안 서버내 무작위 플레이어 한명의", Color.WHITE.code),
                    ComponentUtil.toText("좌표를 추적합니다.", Color.WHITE.code),
                )
            )
        }
    }
}