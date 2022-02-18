package net.alanproject.mygame.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.response.game.Game
import net.alanproject.domain.usecase.GetGame
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGame: GetGame
) : ViewModel() {

    private val _game = MutableStateFlow<Game>(Game())
    val game: StateFlow<Game> = _game


    fun onLoadGame(id: Int) {
        viewModelScope.launch {
            getGame(_game, id)
        }
    }

    private suspend fun getGame(

        _game: MutableStateFlow<Game>,
        id: Int

    ) {
        val result = getGame.get(id = id)

        when (result) {
            is Resource.Success -> {
                Timber.d("result(success): ${result.data}")
                _game.value = result.data ?:Game()
                Timber.d("result(_games): ${_game.value}")
            }
            is Resource.Error -> {
                Timber.e("result(error): ${result.message}")
            }

        }
    }
}