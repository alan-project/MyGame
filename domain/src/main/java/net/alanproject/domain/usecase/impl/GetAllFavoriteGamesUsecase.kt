package net.alanproject.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.GetAllFavoriteGames
import net.alanproject.domain.util.Resource
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllFavoriteGamesUsecase @Inject constructor(
    private val gameRepository: GameRepository
):GetAllFavoriteGames {
    override suspend fun get(): Flow<List<GameInfo>> {


        return gameRepository.getAllFavoriteGames()
//        val response = try {
//            gameRepository.getAllFavoriteGames()
//        } catch (exception: Exception) {
//            Timber.e("exception: $exception")
//            return Resource.Error("An unknown error occured")
//        }
//        return Resource.Success(response)
    }
}