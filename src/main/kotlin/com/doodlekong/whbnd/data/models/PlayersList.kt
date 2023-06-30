package com.doodlekong.whbnd.data.models

import com.doodlekong.whbnd.util.Constants.TYPE_PLAYERS_LIST

data class PlayersList(
    val playersList: List<PlayerData>
): BaseModel(TYPE_PLAYERS_LIST)
