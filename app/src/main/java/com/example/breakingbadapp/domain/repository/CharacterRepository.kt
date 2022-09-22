package com.example.breakingbadapp.domain.repository

import com.example.breakingbadapp.data.remote.dto.CharacterDetailDto
import com.example.breakingbadapp.data.remote.dto.CharacterDto

interface CharacterRepository {

    suspend fun getCharacters(): List<CharacterDto>

    suspend fun getCharacterById(characterId: Int): CharacterDetailDto
}