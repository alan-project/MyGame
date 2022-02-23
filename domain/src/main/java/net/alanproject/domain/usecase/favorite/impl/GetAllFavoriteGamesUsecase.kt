package net.alanproject.domain.usecase.favorite.impl

import kotlinx.coroutines.flow.Flow
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.favorite.GetAllFavoriteGames
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllFavoriteGamesUsecase @Inject constructor(
    private val gameRepository: GameRepository
): GetAllFavoriteGames {
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