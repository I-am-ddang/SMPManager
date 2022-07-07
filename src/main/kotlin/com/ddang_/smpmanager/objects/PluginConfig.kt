package com.ddang_.smpmanager.objects

import com.ddang_.smpmanager.managers.EventCage

class PluginConfig (var quickMenu: Boolean,
                    var randomRespawn: Boolean,
                    var randomRespawnRange: Int,
                    val eventCage: EventCage)