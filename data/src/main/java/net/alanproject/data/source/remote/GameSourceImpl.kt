package net.alanproject.data.source.remote

import net.alanproject.data.source.GameSource
import net.alanproject.domain.model.response.games.Games
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameSourceImpl @Inject constructor(
    private val gameService: GameService
) : GameSource {

    override suspend fun getGames(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Games = gameService.getGames(
        page = page,
        ordering = ordering,
        dates = dates,
        platforms = platforms,
        genres = genres
    )
}