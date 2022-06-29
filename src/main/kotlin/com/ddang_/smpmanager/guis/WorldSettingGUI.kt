package com.ddang_.smpmanager.guis

import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.managers.GUIManager
import com.ddang_.smpmanager.managers.WorldSettingOptionManager
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Bukkit
import org.bukkit.GameRule
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class WorldSettingGUI: CustomGUIHolder() {
    override fun clickProcess(e: InventoryClickEvent) {

        val p = e.whoClicked as Player

        e.isCancelled = true

        val item = e.currentItem ?: return

        val worldName = ItemUtil.getStringPDC(item, "identify") ?: return

        when (e.click) {
            ClickType.LEFT -> { //채팅
                val w = Bukkit.getWorld(worldName) ?: return
                val wso = WorldSettingOptionManager.getWorldSettingOption(w.name) ?: return
                when (wso.chatOption) {
                    true -> {
                        wso.chatOption = false
                        p.sendMessage("§c§l  활성화 §f${w.name} 세계에서 채팅 사용 여부를 비활성화 했습니다.")
                        val i = GUIManager.getInventory(InventoryName.WORLD_SETTING)
                        p.openInventory(i)
                        p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
                    }
                    false -> {
                        wso.chatOption = true
                        p.sendMessage("§a§l  비활성화 §f${w.name} 세계에서 채팅 사용 여부를 활성화 했습니다.")
                        val i = GUIManager.getInventory(InventoryName.WORLD_SETTING)
                        p.openInventory(i)
                        p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
                    }
                }
            }
            ClickType.RIGHT -> { //좌표
                val w = Bukkit.getWorld(worldName) ?: return
                val wso = WorldSettingOptionManager.getWorldSettingOption(w.name) ?: return
                when (wso.coordinateOption) {
                    true -> {
                        wso.coordinateOption = false
                        p.sendMessage("§c§l  활성화 §f${w.name} 세계에서 좌표 확인 여부를 비활성화 했습니다.")
                        w.setGameRule(GameRule.REDUCED_DEBUG_INFO, true)
                        val i = GUIManager.getInventory(InventoryName.WORLD_SETTING)
                        p.openInventory(i)
                        p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
                    }
                    false -> {
                        wso.coordinateOption = true
                        p.sendMessage("§c§l  비활성화 §f${w.name} 세계에서 좌표 확인 여부를 비활성화 했습니다.")
                        w.setGameRule(GameRule.REDUCED_DEBUG_INFO, false)
                        val i = GUIManager.getInventory(InventoryName.WORLD_SETTING)
                        p.openInventory(i)
                        p.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
                    }
                }
            }
            else -> {
                return
            }
        }
    }

    override fun closeProcess(e: InventoryCloseEvent) {
        return
    }
}