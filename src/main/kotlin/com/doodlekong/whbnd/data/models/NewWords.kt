package com.doodlekong.whbnd.data.models

import com.doodlekong.whbnd.util.Constants.TYPE_NEW_WORDS

data class NewWords(
    val newWords: List<String>
): BaseModel(TYPE_NEW_WORDS)
