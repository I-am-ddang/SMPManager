package com.ddang_.smpmanager.objects

import com.ddang_.smpmanager.objects.cages.EventCage
import com.ddang_.smpmanager.objects.cages.RecipeCage

class PluginConfig (var quickMenu: Boolean,
                    var randomRespawn: Boolean,
                    var randomRespawnRange: Int,
                    val eventCage: EventCage,
                    val recipeCage: RecipeCage
)