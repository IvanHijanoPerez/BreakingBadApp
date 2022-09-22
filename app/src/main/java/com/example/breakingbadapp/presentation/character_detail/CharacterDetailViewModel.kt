package com.example.breakingbadapp.presentation.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadapp.common.Constants
import com.example.breakingbadapp.common.Resource
import com.example.breakingbadapp.domain.use_case.get_character.GetCharacterUseCase
import com.example.breakingbadapp.domain.use_case.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getCharacter(characterId.toInt())
        }
    }

    private fun getCharacter(characterId: Int) {
        getCharacterUseCase(characterId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailState(character = result.data)
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}