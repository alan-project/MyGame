package net.alanproject.mygame.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.usecase.favorite.DeleteFavoriteGame
import net.alanproject.domain.usecase.favorite.GetAllFavoriteGames
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteGames: GetAllFavoriteGames,
    private val deleteFavoriteGame: DeleteFavoriteGame
) : ViewModel() {

    private val _favoriteGames = MutableStateFlow<List<GameInfo>>(listOf())
    val favoriteGames: StateFlow<List<GameInfo>> = _favoriteGames


    fun onLoadGames() {
        viewModelScope.launch {


            getAllFavoriteGames.get()
                .collect { gameInfoList->
                    _favoriteGames.value = gameInfoList
                }

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

    fun removeFavorite(gameId:Int) {
        viewModelScope.launch { deleteFavoriteGame.delete(gameId) }
    }
}