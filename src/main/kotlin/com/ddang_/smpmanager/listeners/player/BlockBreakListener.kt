package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.managers.CustomEventManager
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

class BlockBreakListener: Listener {

    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        val p = e.player
        val b = e.block

        if (b.type == Material.OAK_LEAVES) {
            if (!Smpmanager.pluginConfig.eventCage.magicApple) {
                return
            }
            if (CustomEventManager.oakLeafList.contains(b)) {
                return
            }
            if (Random.nextInt(1000) == 0) {
                p.world.playSound(p.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 2f)
                p.inventory.addItem(ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1))
            }
        }
    }
}