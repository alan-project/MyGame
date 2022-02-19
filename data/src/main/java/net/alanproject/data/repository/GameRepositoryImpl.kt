package net.alanproject.data.repository

import net.alanproject.data.source.GameSource
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.Games
import net.alanproject.domain.repository.GameRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val gameSource:GameSource
):GameRepository {
    override suspend fun getGames(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Games {
        return gameSource.getGames(
            page = page,
            ordering = ordering,
            dates = dates,
            platforms = platforms,
            genres = genres
        )
    }

    override suspend fun getGame(id: Int): Game {
        return gameSource.getGame(id)
    }
}