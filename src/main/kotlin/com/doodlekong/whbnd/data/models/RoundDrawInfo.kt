package com.doodlekong.whbnd.data.models

import com.doodlekong.whbnd.util.Constants.TYPE_CURRENT_ROUND_DRAW_INFO

data class RoundDrawInfo(
    val data: List<String>
): BaseModel(TYPE_CURRENT_ROUND_DRAW_INFO)
