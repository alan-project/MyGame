package net.alanproject.mygame.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.usecase.GetAllFavoriteGames
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteGames: GetAllFavoriteGames
) : ViewModel() {

    private val _favoriteGames = MutableStateFlow<List<GameInfo>>(listOf())
    val favoriteGames: StateFlow<List<GameInfo>> = _favoriteGames


    fun onLoadGames() {
        viewModelScope.launch {


            val result: StateFlow<List<GameInfo>> =
                getAllFavoriteGames.get()
                    .stateIn(
                        scope = viewModelScope
                    )

            Timber.d("[favorite] result: ${result.value}")
            _favoriteGames.value = result.value

//            val favoriteGames: Resource<Flow<List<Game>>> =
//                getAllFavoriteGames.get()
//
//
//
//
//            when (favoriteGames) {
//                is Resource.Success -> {
//
//                    _favoriteGames.value = flow{
//                        emit(favoriteGames)
//                    }.stateIn(
//                        scope = viewModelScope,
//                        started = SharingStarted.WhileSubscribed(5000),
//                        initialValue = MutableStateFlow(List<GameInfo>)
//                    )
//                }
//                is Resource.Error -> Timber.e("result(error): ${result.message}")
//            }
        }
    }
}