package net.alanproject.mygame.ui.home.rank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.response.games.Result
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    private val _games = MutableStateFlow<List<Result>>(listOf())
    val games: StateFlow<List<Result>>
        get() = _games

    fun onLoadGames(genres: String) {
        try {
            viewModelScope.launch {
                getGamesByParams(_games, genres = genres)
            }
        } catch (exception: Exception) {
            Timber.e("throwable: $exception")
        }
    }

    private suspend fun getGamesByParams(
        _games: MutableStateFlow<List<Result>>,
        page: Int? = 1,
        ordering: String? = "-added",
        dates: String? = null,
        platforms: String? = null,
        genres: String? = null
    ) {
        Timber.d("agoDate: $dates")
        Timber.d("genres: $genres")
        val result = getGames.get(
            page = page,
            ordering = ordering,
            dates = dates,
            platforms = platforms,
            genres = genres
        )

        when (result) {
            is Resource.Success -> {
                Timber.d("result(success): ${result.data?.results?.first()}")
                _games.value = result.data?.results ?: listOf()
                Timber.d("result(_games): ${_games.value.first()}")
            }
            is Resource.Error -> {
                Timber.e("result(error): ${result.message}")
            }

        }
    }
}