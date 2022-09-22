package com.example.breakingbadapp.domain.model

data class CharacterDetail(
    val birthday: String,
    val category: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val status: String
)
