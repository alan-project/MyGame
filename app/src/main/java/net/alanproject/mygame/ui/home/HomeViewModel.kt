package net.alanproject.mygame.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import net.alanproject.domain.common.Resource
import net.alanproject.domain.usecase.GetGames
import timber.log.Timber

class HomeViewModel(
    private val getGames: GetGames
):ViewModel() {

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

            }
            is Resource.Error ->{

            }

        }
    }
}