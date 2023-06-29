package com.doodlekong.whbnd.data.models

import com.doodlekong.whbnd.data.Room
import com.doodlekong.whbnd.util.Constants.TYPE_PHASE_CHANGE

data class PhaseChange(
    var phase: Room.Phase?,
    var time: Long,
    val drawingPlayer: String? = null
): BaseModel(TYPE_PHASE_CHANGE)
