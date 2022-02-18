package net.alanproject.mygame.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.response.games.Result
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.util.DateUnit
import net.alanproject.domain.util.Resource
import net.alanproject.domain.util.agoDate
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {


    private val _games = MutableStateFlow<List<Result>>(listOf())
    val games: StateFlow<List<Result>>
        get() = _games


    private var curPage: Int = 1

    fun onLoadingGames() {

        viewModelScope.launch {
            getGamesByParams(
                page = curPage++,
                _games = _games,
                dates = DateUnit.ONE_YEAR.agoDate()
            )
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

                _games.value = result.data?.results?: mutableListOf()
            }
            is Resource.Error -> {
                Timber.e("result(error): ${result.message}")
            }

        }
    }
}