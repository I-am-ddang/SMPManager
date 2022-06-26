package com.ddang_.smpmanager.utils

import com.ddang_.smpmanager.Smpmanager
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.persistence.PersistentDataType

class ItemUtil {
    companion object {
        fun toItem(
            material: Material,
            amount: Int,
            name: Component,
            loreLine: List<Component>
        ): ItemStack {
            val i = ItemStack(material, amount)
            val meta = i.itemMeta.apply {
                displayName(name)
                lore(loreLine)
                addItemFlags(
                    ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES
                )
            }
            i.itemMeta = meta
            return i
        }

        fun toHead(name: Component,
                   owner: Player,
                   amount: Int,
                   loreLine: List<Component>): ItemStack {
            val i = ItemStack(Material.PLAYER_HEAD, amount)
            val meta = i.itemMeta as SkullMeta
            meta.displayName(name)
            meta.owningPlayer = owner
            meta.lore(loreLine)
            meta.addItemFlags(
                ItemFlag.HIDE_ENCHANTS)
            i.itemMeta = meta
            return i
        }

        fun applyStringPDC(itemstack: ItemStack, keyName: String, value: String): ItemStack {
            val key = NamespacedKey(Smpmanager.instance, keyName)
            val meta = itemstack.itemMeta.apply {
                persistentDataContainer.set(key, PersistentDataType.STRING, value)
            }
            itemstack.itemMeta = meta
            return itemstack
        }

        fun getStringPDC(itemstack: ItemStack, keyName: String): String? {
            val meta = itemstack.itemMeta
            val key = NamespacedKey(Smpmanager.instance, keyName)
            return meta.persistentDataContainer.get(key, PersistentDataType.STRING)
        }
    }
}