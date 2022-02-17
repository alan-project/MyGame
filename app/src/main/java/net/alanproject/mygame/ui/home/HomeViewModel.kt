package net.alanproject.mygame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import net.alanproject.domain.model.response.games.Result
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.util.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {

    private val _updateGames = MutableStateFlow<List<Result>>(listOf())
    val updateGames: StateFlow<List<Result>> = _updateGames

    //What's Hot Now
    private val _releaseGames = MutableStateFlow<List<Result>>(listOf())
    val releaseGames: StateFlow<List<Result>> = _releaseGames

    private val _upcomingGames = MutableStateFlow<List<Result>>(listOf())
    val upcomingGames: StateFlow<List<Result>> = _upcomingGames

    //By Genre
    private val _actionGames = MutableStateFlow<List<Result>>(listOf())
    val actionGames: StateFlow<List<Result>> = _actionGames

    private val _strategyGames = MutableStateFlow<List<Result>>(listOf())
    val strategyGames: StateFlow<List<Result>> = _strategyGames

    private val _puzzleGames = MutableStateFlow<List<Result>>(listOf())
    val puzzleGames: StateFlow<List<Result>> = _puzzleGames

    private val _racingGames = MutableStateFlow<List<Result>>(listOf())
    val racingGames: StateFlow<List<Result>> = _racingGames

    fun onLoadGames() {

        try {
            viewModelScope.launch {
                joinAll(
                    launch {
                        getGamesByParams(
                            _updateGames,
                            dates = DateUnit.ONE_WEEK.agoDate()
                        )
                        getGamesByParams(
                            _releaseGames,
                            dates = DateUnit.ONE_MONTH.agoDate()
                        )
                        getGamesByParams(
                            _upcomingGames,
                            dates = DateUnit.THREE_MONTH.afterDate()
                        )
                        getGamesByParams(
                            _actionGames,
                            dates = DateUnit.SIX_MONTH.agoDate(),
                            genres = Genre.ACTION
                        )
                        getGamesByParams(
                            _strategyGames,
                            dates = DateUnit.SIX_MONTH.agoDate(),
                            genres = Genre.STRATEGY
                        )
                        getGamesByParams(
                            _puzzleGames,
                            dates = DateUnit.SIX_MONTH.agoDate(),
                            genres = Genre.PUZZLE
                        )
                        getGamesByParams(
                            _racingGames,
                            dates = DateUnit.SIX_MONTH.agoDate(),
                            genres = Genre.SPORT
                        )
                    }
                )
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