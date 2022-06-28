package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.guis.MenuGUI
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.Inventory

class GUIManager {
    companion object {
        fun getInventory(inventoryName: InventoryName): Inventory {
            when (inventoryName) {
                InventoryName.MENU -> {
                    val i = Bukkit.createInventory(MenuGUI(), 18, ComponentUtil.toText(
                        "메뉴", "000000"
                    ))

                    for (n in 0..8) {
                        i.setItem(n, ItemUtil.toItem(
                            Material.ORANGE_STAINED_GLASS_PANE, 1,
                            ComponentUtil.toText("지속적인 기능", Color.GOLD.code),
                            arrayListOf(
                                ComponentUtil.toText("", Color.WHITE.code),
                                ComponentUtil.toText("해당 줄에 위치한 기능들은 지속적인 기능으로", Color.WHITE.code),
                                ComponentUtil.toText("끄고 켤 수 있습니다.", Color.WHITE.code)
                            )
                        ))
                    }

                    for (n in 9..17) {
                        i.setItem(n, ItemUtil.toItem(
                            Material.LIME_STAINED_GLASS_PANE, 1,
                            ComponentUtil.toText("일회성 기능", Color.LIME.code),
                            arrayListOf(
                                ComponentUtil.toText("", Color.WHITE.code),
                                ComponentUtil.toText("해당 줄에 위치한 기능들은 일회성 기능으로", Color.WHITE.code),
                                ComponentUtil.toText("시작과 끝이 있습니다.", Color.WHITE.code)
                            )
                        ))
                    }

                    var item = ItemUtil.toItem(
                        Material.PLAYER_HEAD, 1,
                        ComponentUtil.toText("모든 플레이어 재배치", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("모든 플레이어를 자신의 월드의 특정 범위", Color.WHITE.code),
                            ComponentUtil.toText("안에 무작위로 재배치합니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 진행합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "0")
                    i.setItem(10, item)

                    item = ItemUtil.toItem(
                        Material.CRAFTING_TABLE, 1,
                        ComponentUtil.toText("특수 아이템 조합법 설정", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("특수한 아이템을 얻을 수 있는", Color.WHITE.code),
                            ComponentUtil.toText("조합법을 활성화하거나 조합식을 바꿉니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 설정합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "1")

                    i.setItem(1, item)

                    item = ItemUtil.toItem(
                        Material.SKELETON_SKULL, 1,
                        ComponentUtil.toText("사망시 무작위 위치 재배치 설정", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("사망시 오버월드의 무작위 위치에서", Color.WHITE.code),
                            ComponentUtil.toText("부활하도록 설정합니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 설정합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "2")
                    i.setItem(2, item)

                    item = ItemUtil.toItem(
                        Material.COMPASS, 1,
                        ComponentUtil.toText("특정 월드 좌표와 채팅 가리기 설정", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("특정 월드에서 좌표를 볼 수 없게 하고", Color.WHITE.code),
                            ComponentUtil.toText("채팅을 보낼 수 없게 설정합니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 설정합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "3")

                    i.setItem(3, item)

                    item = ItemUtil.toItem(
                        Material.TOTEM_OF_UNDYING, 1,
                        ComponentUtil.toText("특수 행사 개최", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("서버에서 진행하는 특수 행사를", Color.WHITE.code),
                            ComponentUtil.toText("살펴보고 개최할 수 있습니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 진행합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "4")

                    i.setItem(11, item)

                    return i
                }
            }
        }
    }
}