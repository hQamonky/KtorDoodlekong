package com.doodlekong.whbnd.data.models

import com.doodlekong.whbnd.util.Constants.TYPE_GAME_STATE

data class GameState(
    val drawingPlayer: String,
    val word: String
): BaseModel(TYPE_GAME_STATE)
