package com.example.breakingbadapp.domain.use_case.get_characters

import com.example.breakingbadapp.common.Resource
import com.example.breakingbadapp.data.remote.dto.toCharacter
import com.example.breakingbadapp.domain.model.Character
import com.example.breakingbadapp.domain.model.CharacterDetail
import com.example.breakingbadapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val characters = repository.getCharacters().map { it.toCharacter() }
            emit(Resource.Success<List<Character>>(characters))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Character>>("Couldn't reach server. Check your internet connection"))
        }
    }
}