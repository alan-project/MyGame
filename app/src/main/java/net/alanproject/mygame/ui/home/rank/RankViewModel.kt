package net.alanproject.mygame.ui.home.rank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    private val _games = MutableStateFlow<List<GameInfo>>(listOf())
    val games: StateFlow<List<GameInfo>>
        get() = _games

    fun onLoadGames(genres: String) {
        try {
            viewModelScope.launch {

                when (val result = getGames.get(genres = genres)) {
                    is Resource.Success -> _games.value = result.data?.results ?: listOf()
                    is Resource.Error -> Timber.e("result(error): ${result.message}")
                }
            }
        } catch (exception: Exception) {
            Timber.e("throwable: $exception")
        }
    }

}