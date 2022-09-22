package com.example.breakingbadapp.presentation.character_detail

import com.example.breakingbadapp.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = ""
)
