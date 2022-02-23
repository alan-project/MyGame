package net.alanproject.domain.usecase.favorite.impl

import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.favorite.DeleteAllFavoriteGames
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteAllFavoriteGamesUsecase @Inject constructor(
    private val gameRepository: GameRepository
): DeleteAllFavoriteGames {
    override suspend fun delete() {
        gameRepository.deleteAllFavoriteGame()
    }
}