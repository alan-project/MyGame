package net.alanproject.mygame.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.Game
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

            when(val result = getGame.get(id = id)){
                is Resource.Success -> _game.value = result.data?:Game()
                is Resource.Error -> Timber.e("result(error): ${result.message}")
            }
        }
    }

}