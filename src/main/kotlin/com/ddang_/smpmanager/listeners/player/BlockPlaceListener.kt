package com.ddang_.smpmanager.listeners.player

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.Smpmanager.Companion.broad
import com.ddang_.smpmanager.managers.CustomEventManager
import com.ddang_.smpmanager.managers.CustomItemManager
import com.ddang_.smpmanager.utils.ItemUtil
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.Material
import org.bukkit.entity.Firework
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack

class BlockPlaceListener: Listener {
    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val p = e.player
        val loc = e.block.location

        //마법이 걸린 사과나무
        if (e.block.type == Material.OAK_LEAVES) {
            if (!Smpmanager.pluginConfig.eventCage.magicApple) {
                return
            }
            CustomEventManager.oakLeafList.add(e.block)

        }

        //엔더 드래곤의 가호
        if (e.block.type == Material.DRAGON_EGG) {
            if (!Smpmanager.pluginConfig.eventCage.enderDragon) {
                return
            }

            val eLoc = Smpmanager.pluginConfig.eventCage.enderDragonLoc ?: return
            if (loc != eLoc) {
                return
            }

            ("§5§l  엔더 드래곤의 가호 §f${p.name}님이 엔더 드래곤의 가호를 획득했습니다.").broad()

            val fw = p.world.spawn(loc, Firework::class.java)
            val builder = FireworkEffect.builder()
            val fwm = fw.fireworkMeta
            fwm.addEffect(builder.flicker(true).withColor(Color.PURPLE).build())
            fwm.addEffect(builder.with(FireworkEffect.Type.STAR).build())
            fwm.addEffect(builder.trail(true).withColor(Color.WHITE).build())
            fwm.addEffect(builder.withFade(Color.PURPLE).build())
            fwm.power = 2
            fw.fireworkMeta = fwm

            //아이템 지급
            val item = CustomItemManager.getCustomItem(1)?.toItem() ?: ItemStack(Material.WOODEN_SWORD)
            ItemUtil.applyStringPDC(item, "customItem", "1")
            p.inventory.addItem(item)
            return
        }
    }
}