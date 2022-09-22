package com.example.breakingbadapp.domain.use_case.get_character

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

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(characterId: Int): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading<CharacterDetail>())
            val character = repository.getCharacterById(characterId)[0].toCharacter()
            emit(Resource.Success<CharacterDetail>(character))
        } catch (e: HttpException) {
            emit(Resource.Error<CharacterDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CharacterDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}