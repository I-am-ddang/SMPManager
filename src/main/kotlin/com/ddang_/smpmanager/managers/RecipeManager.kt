package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

class RecipeManager {
    companion object {

        fun registerAll() {
            registerTracker()
        }

        fun registerTracker() {
            val trackerKey = NamespacedKey(Smpmanager.instance, "tracker")
            val trackerResult = CustomItemManager.getCustomItem(2)?.toItem() ?: ItemStack(Material.WOODEN_SWORD)
            trackerResult.addUnsafeEnchantment(Enchantment.OXYGEN, 1)

            val trackerRecipe = ShapedRecipe(trackerKey, trackerResult)

            val a = if (Smpmanager.pluginConfig.recipeCage.tracker.slot0.type != Material.AIR) "a" else " "
            val b = if (Smpmanager.pluginConfig.recipeCage.tracker.slot1.type != Material.AIR) "b" else " "
            val c = if (Smpmanager.pluginConfig.recipeCage.tracker.slot2.type != Material.AIR) "c" else " "
            val d = if (Smpmanager.pluginConfig.recipeCage.tracker.slot3.type != Material.AIR) "d" else " "
            val e = if (Smpmanager.pluginConfig.recipeCage.tracker.slot4.type != Material.AIR) "e" else " "
            val f = if (Smpmanager.pluginConfig.recipeCage.tracker.slot5.type != Material.AIR) "f" else " "
            val g = if (Smpmanager.pluginConfig.recipeCage.tracker.slot6.type != Material.AIR) "g" else " "
            val h = if (Smpmanager.pluginConfig.recipeCage.tracker.slot7.type != Material.AIR) "h" else " "
            val i = if (Smpmanager.pluginConfig.recipeCage.tracker.slot8.type != Material.AIR) "i" else " "

            trackerRecipe.shape("$a$b$c", "$d$e$f", "$g$h$i")

            if (a.isNotEmpty()) {
                trackerRecipe.setIngredient(a[0], Smpmanager.pluginConfig.recipeCage.tracker.slot0.type)
            }
            if (b.isNotEmpty()) {
                trackerRecipe.setIngredient(b[0], Smpmanager.pluginConfig.recipeCage.tracker.slot1.type)
            }
            if (c.isNotEmpty()) {
                trackerRecipe.setIngredient(c[0], Smpmanager.pluginConfig.recipeCage.tracker.slot2.type)
            }
            if (d.isNotEmpty()) {
                trackerRecipe.setIngredient(d[0], Smpmanager.pluginConfig.recipeCage.tracker.slot3.type)
            }
            if (e.isNotEmpty()) {
                trackerRecipe.setIngredient(e[0], Smpmanager.pluginConfig.recipeCage.tracker.slot4.type)
            }
            if (f.isNotEmpty()) {
                trackerRecipe.setIngredient(f[0], Smpmanager.pluginConfig.recipeCage.tracker.slot5.type)
            }
            if (g.isNotEmpty()) {
                trackerRecipe.setIngredient(g[0], Smpmanager.pluginConfig.recipeCage.tracker.slot6.type)
            }
            if (h.isNotEmpty()) {
                trackerRecipe.setIngredient(h[0], Smpmanager.pluginConfig.recipeCage.tracker.slot7.type)
            }
            if (i.isNotEmpty()) {
                trackerRecipe.setIngredient(i[0], Smpmanager.pluginConfig.recipeCage.tracker.slot8.type)
            }
        }
    }
}