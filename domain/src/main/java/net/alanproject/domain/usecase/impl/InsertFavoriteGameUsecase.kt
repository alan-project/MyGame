package net.alanproject.domain.usecase.impl

import net.alanproject.domain.model.Game
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.InsertFavoriteGame
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsertFavoriteGameUsecase @Inject constructor(
    private val gameRepository: GameRepository
): InsertFavoriteGame {
    override suspend fun insert(game: Game) {
        gameRepository.insertFavoriteGame(game)
    }
}