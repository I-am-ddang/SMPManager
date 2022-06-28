package com.ddang_.smpmanager.managers

import com.ddang_.smpmanager.Smpmanager
import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.objects.Member
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

class MemberManager {
    companion object {
        val memberList = arrayListOf<Member>()

        fun getMember(name: String) = memberList.find { it.player.name == name }

        fun save(p: Player) {

        }

        fun set(p: Player) {

            Member(p, ChatState.NONE)
        }
    }
}