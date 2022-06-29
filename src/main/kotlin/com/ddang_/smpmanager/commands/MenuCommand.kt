package com.ddang_.smpmanager.commands

import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.enums.InventoryName
import com.ddang_.smpmanager.managers.GUIManager
import com.ddang_.smpmanager.managers.MemberManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MenuCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            return false
        }

        val m = MemberManager.getMember(sender.name) ?: return false
        if (m.chatState != ChatState.NONE) {
            sender.sendMessage("§c먼저 채팅을 입력해 작업을 마쳐주십시오.")
            return false
        }

        val i = GUIManager.getInventory(InventoryName.MENU)
        sender.openInventory(i)

        return false
    }
}