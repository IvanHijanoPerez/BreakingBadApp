package com.example.breakingbadapp.data.remote

import com.example.breakingbadapp.data.remote.dto.CharacterDetailDto
import com.example.breakingbadapp.data.remote.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApi {

    @GET("/api/characters")
    suspend fun  getCharacters(): List<CharacterDto>

    @GET("/api/characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): CharacterDetailDto
}