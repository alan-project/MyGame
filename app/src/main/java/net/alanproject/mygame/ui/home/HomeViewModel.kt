package net.alanproject.mygame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import net.alanproject.domain.common.Resource
import net.alanproject.domain.model.response.games.Result
import net.alanproject.domain.usecase.GetGames
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGames: GetGames
):ViewModel() {

    private val _games = MutableStateFlow<List<Result>>(listOf())
    val games: StateFlow<List<Result>> = _games

    fun onLoadGames(){

        try{
            viewModelScope.launch {
                joinAll(
                    launch { getGamesByCategory() }
                )
            }
        }catch (exception: Exception){
            Timber.e("throwable: $exception")
        }
    }

    private suspend fun getGamesByCategory(){
       val result =  getGames.get()

        when(result){
            is Resource.Success ->{
                Timber.d("result(success): ${result.data?.results}")
                _games.value = result.data?.results ?: listOf()
            }
            is Resource.Error ->{
                Timber.e("result(error): ${result.data?.results}")
            }

        }
    }
}