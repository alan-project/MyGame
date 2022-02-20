package net.alanproject.domain.usecase.impl

import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.DeleteAllFavoriteGames
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