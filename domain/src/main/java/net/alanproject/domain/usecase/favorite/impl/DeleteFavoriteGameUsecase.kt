package net.alanproject.domain.usecase.favorite.impl

import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.favorite.DeleteFavoriteGame
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteFavoriteGameUsecase @Inject constructor(
    private val gameRepository: GameRepository
): DeleteFavoriteGame {
    override suspend fun delete(gameId: Int) {
        gameRepository.deleteFavoriteGame(gameId)
    }
}