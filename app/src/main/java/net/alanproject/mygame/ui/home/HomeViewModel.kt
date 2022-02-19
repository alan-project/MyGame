package net.alanproject.mygame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.util.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    private val _updateGames = MutableStateFlow<List<GameInfo>>(listOf())
    val updateGames: StateFlow<List<GameInfo>> = _updateGames

    //What's Hot Now
    private val _releaseGames = MutableStateFlow<List<GameInfo>>(listOf())
    val releaseGames: StateFlow<List<GameInfo>> = _releaseGames

    private val _upcomingGames = MutableStateFlow<List<GameInfo>>(listOf())
    val upcomingGames: StateFlow<List<GameInfo>> = _upcomingGames

    //By Genre
    private val _actionGames = MutableStateFlow<List<GameInfo>>(listOf())
    val actionGames: StateFlow<List<GameInfo>> = _actionGames

    private val _strategyGames = MutableStateFlow<List<GameInfo>>(listOf())
    val strategyGames: StateFlow<List<GameInfo>> = _strategyGames

    private val _puzzleGames = MutableStateFlow<List<GameInfo>>(listOf())
    val puzzleGames: StateFlow<List<GameInfo>> = _puzzleGames

    private val _racingGames = MutableStateFlow<List<GameInfo>>(listOf())
    val racingGames: StateFlow<List<GameInfo>> = _racingGames

    fun onLoadGames() {

        try {
            viewModelScope.launch {

                launch {
                    getGamesByParams(
                        _updateGames,
                        dates = DateUnit.ONE_MONTH.agoDate()
                    )
                }
                launch {
                    getGamesByParams(
                        _releaseGames,
                        dates = DateUnit.ONE_MONTH.agoDate()
                    )
                }
                launch {
                    getGamesByParams(
                        _upcomingGames,
                        dates = DateUnit.THREE_MONTH.afterDate()
                    )
                }
                launch {
                    getGamesByParams(
                        _actionGames,
                        dates = DateUnit.SIX_MONTH.agoDate(),
                        genres = Genre.ACTION
                    )
                }
                launch {
                    getGamesByParams(
                        _strategyGames,
                        dates = DateUnit.SIX_MONTH.agoDate(),
                        genres = Genre.STRATEGY
                    )
                }

                launch {
                    getGamesByParams(
                        _puzzleGames,
                        dates = DateUnit.SIX_MONTH.agoDate(),
                        genres = Genre.PUZZLE
                    )
                }

                launch {

                    getGamesByParams(
                        _racingGames,
                        dates = DateUnit.SIX_MONTH.agoDate(),
                        genres = Genre.SPORT
                    )
                }
            }
        } catch (exception: Exception) {
            Timber.e("throwable: $exception")
        }
    }

    private suspend fun getGamesByParams(
        games: MutableStateFlow<List<GameInfo>>,
        dates: String? = null,
        platforms: String? = null,
        genres: String? = null
    ) {
        Timber.d("agoDate: $dates")
        Timber.d("genres: $genres")
        val result = getGames.get(
            dates = dates,
            platforms = platforms,
            genres = genres
        )

        when (result) {
            is Resource.Success -> {
                Timber.d("result(success): ${result.data?.results?.first()}")
                games.value = result.data?.results?: listOf()
                Timber.d("result(_games): ${games.value.first()}")
            }
            is Resource.Error -> {
                Timber.e("result(error): ${result.message}")
            }

        }
    }
}