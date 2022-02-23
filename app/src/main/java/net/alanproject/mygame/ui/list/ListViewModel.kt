package net.alanproject.mygame.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.usecase.game.GetGames
import net.alanproject.domain.util.DateUnit
import net.alanproject.domain.util.Resource
import net.alanproject.domain.util.agoDate
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getGames: GetGames
) : ViewModel() {


    private val _games = MutableStateFlow<List<GameInfo>>(listOf())
    val games: StateFlow<List<GameInfo>>
        get() = _games


    private var curPage: Int = 1

    fun onLoadingGames() {

        viewModelScope.launch {


            val result = getGames.get(
                page = curPage++,
                dates = DateUnit.ONE_YEAR.agoDate()
            )

            when (result) {
                is Resource.Success -> _games.value = result.data?.results ?: mutableListOf()
                is Resource.Error -> Timber.e("result(error): ${result.message}")
            }
        }
    }
}