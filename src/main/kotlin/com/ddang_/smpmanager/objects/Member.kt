package com.ddang_.smpmanager.objects

import com.ddang_.smpmanager.enums.ChatState
import com.ddang_.smpmanager.managers.MemberManager
import org.bukkit.entity.Player

class Member (val player: Player, var chatState: ChatState, var target: Player?) {
    init {
        MemberManager.memberList.add(this)
    }
}