package com.example.breakingbadapp.data.repository

import com.example.breakingbadapp.data.remote.BreakingBadApi
import com.example.breakingbadapp.data.remote.dto.CharacterDetailDto
import com.example.breakingbadapp.data.remote.dto.CharacterDto
import com.example.breakingbadapp.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: BreakingBadApi
) : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterDto> {
        return api.getCharacters()
    }

    override suspend fun getCharacterById(characterId: Int): CharacterDetailDto {
        return api.getCharacterById(characterId)
    }
}