package com.example.breakingbadapp.presentation.character_list

import com.example.breakingbadapp.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
