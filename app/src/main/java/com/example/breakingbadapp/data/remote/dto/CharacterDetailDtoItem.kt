package com.example.breakingbadapp.data.remote.dto

import com.example.breakingbadapp.domain.model.Character
import com.example.breakingbadapp.domain.model.CharacterDetail

data class CharacterDetailDtoItem(
    val appearance: List<Int>,
    val better_call_saul_appearance: List<Any>,
    val birthday: String,
    val category: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)

fun CharacterDetailDtoItem.toCharacter(): CharacterDetail {
    return CharacterDetail(
        char_id = char_id,
        img = img,
        name = name,
        status = status,
        birthday = birthday,
        category = category,
        nickname = nickname,
        occupation = occupation
    )
}