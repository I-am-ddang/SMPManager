package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.Color
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.enums.WorldSettingOption
import com.ddang_.smpmanager.guis.MenuGUI
import com.ddang_.smpmanager.guis.RandomRespawnGUI
import com.ddang_.smpmanager.guis.WorldSettingGUI
import com.ddang_.smpmanager.utils.ComponentUtil
import com.ddang_.smpmanager.utils.ItemUtil
import net.kyori.adventure.text.Component
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
                        ComponentUtil.toText("무작위 부활 위치 설정", Color.LIME.code),
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
                InventoryName.RANDOM_RESPAWN -> {
                    val i = Bukkit.createInventory(RandomRespawnGUI(), 9, ComponentUtil.toText(
                        "무작위 부활 위치 설정", "000000"
                    ))

                    val option = Smpmanager.pluginConfig.randomRespawn

                    var item = when (option) {
                        true -> {
                            ItemUtil.toItem(
                                Material.LIME_TERRACOTTA, 1,
                                ComponentUtil.toText("활성화 여부: 활성화", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    ComponentUtil.toText("무작위 위치에서 부활하는 기능을", Color.WHITE.code),
                                    ComponentUtil.toText("활성화한 상태입니다.", Color.WHITE.code),
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    ComponentUtil.toText("클릭시 비활성화합니다.", Color.YELLOW.code)
                                )
                            )
                        }
                        false -> {
                            ItemUtil.toItem(
                                Material.RED_TERRACOTTA, 1,
                                ComponentUtil.toText("활성화 여부: 비활성화", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    ComponentUtil.toText("무작위 위치에서 부활하는 기능을", Color.WHITE.code),
                                    ComponentUtil.toText("비활성화한 상태입니다.", Color.WHITE.code),
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    ComponentUtil.toText("클릭시 활성화합니다.", Color.YELLOW.code)
                                )
                            )
                        }
                    }
                    when (option) {
                        true -> {
                            ItemUtil.applyStringPDC(item, "identify", "0")
                        }
                        false -> {
                            ItemUtil.applyStringPDC(item, "identify", "1")
                        }
                    }
                    i.setItem(0, item)

                    item = ItemUtil.toItem(
                        Material.ENDER_EYE, 1,
                        ComponentUtil.toText("범위 설정", Color.LIME.code),
                        arrayListOf(
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("무작위 위치에서 부활하는 기능의", Color.WHITE.code),
                            ComponentUtil.toText("부활 범위를 설정합니다.", Color.WHITE.code),
                            ComponentUtil.toText("", Color.WHITE.code),
                            ComponentUtil.toText("클릭시 설정합니다.", Color.YELLOW.code)
                        )
                    )
                    ItemUtil.applyStringPDC(item, "identify", "2")
                    i.setItem(1, item)

                    return i
                }
                InventoryName.WORLD_SETTING -> {
                    when (Bukkit.getWorlds().size) {
                        in 1..9 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        in 10..18 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9*2, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        in 19..27 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9*3, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        in 28..36 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9*4, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        in 37..45 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9*5, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        in 46..54 -> {
                            val i = Bukkit.createInventory(WorldSettingGUI(), 9*6, ComponentUtil.toText(
                                "월드 좌표/채팅 설정", "000000"
                            ))

                            worldSettingAssist(i)

                            return i
                        }
                        else -> {
                            return Bukkit.createInventory(null, 9, ComponentUtil.toText(
                                "오류! 세계가 존재하지 않거나 너무 많습니다.", "000000"
                            ))
                        }
                    }
                }
            }
        }

        private fun worldSettingAssist(i: Inventory) {
            for ((count, world) in Bukkit.getWorlds().withIndex()) {
                i.setItem(count,
                    when (world.name) {
                        "WORLD" -> {
                            val w = Bukkit.getWorld("WORLD") ?: return
                            val coord = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.COORDINATE) ?: return
                            val chat = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.CHAT) ?: return
                            val item = ItemUtil.toItem(Material.GRASS_BLOCK, 1,
                                ComponentUtil.toText("오버월드 설정", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    Component.text().append(
                                        ComponentUtil.toText("오버월드 채팅 가능 여부: ", Color.WHITE.code),
                                        chat
                                    ).build(),
                                    Component.text().append(
                                        ComponentUtil.toText("오버월드 좌표 활성화 여부: ", Color.WHITE.code),
                                        coord
                                    ).build(),
                                    ComponentUtil.toText("좌클릭해 채팅 가능 여부를 조절합니다.", Color.YELLOW.code),
                                    ComponentUtil.toText("우클릭해 좌표 표시 여부를 조절합니다.", Color.YELLOW.code)
                                )
                            )
                            ItemUtil.applyStringPDC(item, "identify", world.name)
                            item
                        }
                        "WORLD_NETHER" -> {
                            val w = Bukkit.getWorld("WORLD_NETHER") ?: return
                            val coord = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.COORDINATE) ?: return
                            val chat = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.CHAT) ?: return
                            val item = ItemUtil.toItem(Material.NETHERRACK, 1,
                                ComponentUtil.toText("네더 설정", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    Component.text().append(
                                        ComponentUtil.toText("네더 채팅 가능 여부: ", Color.WHITE.code),
                                        chat
                                    ).build(),
                                    Component.text().append(
                                        ComponentUtil.toText("네더 좌표 활성화 여부: ", Color.WHITE.code),
                                        coord
                                    ).build(),
                                    ComponentUtil.toText("좌클릭해 채팅 가능 여부를 조절합니다.", Color.YELLOW.code),
                                    ComponentUtil.toText("우클릭해 좌표 표시 여부를 조절합니다.", Color.YELLOW.code)
                                )
                            )
                            ItemUtil.applyStringPDC(item, "identify", world.name)
                            item
                        }
                        "WORLD_THE_END" -> {
                            val w = Bukkit.getWorld("WORLD_THE_END") ?: return
                            val coord = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.COORDINATE) ?: return
                            val chat = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.CHAT) ?: return
                            val item = ItemUtil.toItem(Material.END_STONE, 1,
                                ComponentUtil.toText("엔드 설정", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    Component.text().append(
                                        ComponentUtil.toText("엔드 채팅 가능 여부: ", Color.WHITE.code),
                                        chat
                                    ).build(),
                                    Component.text().append(
                                        ComponentUtil.toText("엔드 좌표 활성화 여부: ", Color.WHITE.code),
                                        coord
                                    ).build(),
                                    ComponentUtil.toText("좌클릭해 채팅 가능 여부를 조절합니다.", Color.YELLOW.code),
                                    ComponentUtil.toText("우클릭해 좌표 표시 여부를 조절합니다.", Color.YELLOW.code)
                                )
                            )
                            ItemUtil.applyStringPDC(item, "identify", world.name)
                            item
                        }
                        else -> {
                            val w = world ?: return
                            val coord = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.COORDINATE) ?: return
                            val chat = ComponentUtil.getWorldSettingWhether(w, WorldSettingOption.CHAT) ?: return
                            val item = ItemUtil.toItem(Material.STONE, 1,
                                ComponentUtil.toText("${world.name} 세계 설정", Color.LIME.code),
                                arrayListOf(
                                    ComponentUtil.toText("", Color.WHITE.code),
                                    Component.text().append(
                                        ComponentUtil.toText("${world.name} 세계 채팅 가능 여부: ", Color.WHITE.code),
                                        chat
                                    ).build(),
                                    Component.text().append(
                                        ComponentUtil.toText("${world.name} 세계 좌표 활성화 여부: ", Color.WHITE.code),
                                        coord
                                    ).build(),
                                    ComponentUtil.toText("좌클릭해 채팅 가능 여부를 조절합니다.", Color.YELLOW.code),
                                    ComponentUtil.toText("우클릭해 좌표 표시 여부를 조절합니다.", Color.YELLOW.code)
                                )
                            )
                            ItemUtil.applyStringPDC(item, "identify", world.name)
                            item
                        }
                    }
                )
            }
        }
    }
}