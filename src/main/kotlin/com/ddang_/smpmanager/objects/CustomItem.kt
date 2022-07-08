package com.ddang_.smpmanager.objects

import com.ddang_.smpmanager.managers.CustomItemManager
import com.ddang_.smpmanager.utils.ItemUtil
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class CustomItem (val id: Int,
                  val name: Component,
                  val material: Material,
                  val loreLine: List<Component>) {
    init {
        CustomItemManager.customItemList.add(this)
    }

    fun toItem(): ItemStack {
        val i = ItemStack(material)
        val meta = i.itemMeta.apply {
            displayName(name)
            lore(loreLine)
            addItemFlags(ItemFlag.HIDE_ATTRIBUTES,
                ItemFlag.HIDE_ENCHANTS)
        }
        i.addUnsafeEnchantment(Enchantment.OXYGEN, 1)
        ItemUtil.applyStringPDC(i, "customItem", "$id")

        i.itemMeta = meta
        return i
    }
}