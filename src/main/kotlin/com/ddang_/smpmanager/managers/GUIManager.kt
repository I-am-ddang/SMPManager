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
                    val i = Bukkit.createInventory(MenuGUI(), 9, ComponentUtil.toText(
                        "메뉴", "000000"
                    ))

                    var item = ItemUtil.toItem(
                        Material.PLAYER_HEAD, 1,
                        ComponentUtil.toText("모든 플레이어 재배치", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "0")
                    i.setItem(0, item)

                    item = ItemUtil.toItem(
                        Material.CRAFTING_TABLE, 1,
                        ComponentUtil.toText("특수 조합법 목록", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "1")

                    i.setItem(1, item)

                    item = ItemUtil.toItem(
                        Material.SKELETON_SKULL, 1,
                        ComponentUtil.toText("사망시 무작위 위치 재배치", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "2")
                    i.setItem(2, item)

                    item = ItemUtil.toItem(
                        Material.COMPASS, 1,
                        ComponentUtil.toText("특정 월드 좌표와 채팅 가리기", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "3")

                    i.setItem(3, item)
                    return i
                }
            }
        }
    }
}