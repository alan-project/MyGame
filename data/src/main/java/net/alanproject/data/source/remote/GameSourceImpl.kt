package net.alanproject.data.source.remote

import net.alanproject.data.model.game.mapToDomain
import net.alanproject.data.model.games.mapToDomain
import net.alanproject.data.source.GameSource
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.Games
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
    ): Games{
      return gameService.getGames(
          page = page,
          ordering = ordering,
          dates = dates,
          platforms = platforms,
          genres = genres
      ).mapToDomain()
    }

    override suspend fun getGame(id: Int): Game {
       return  gameService.getGame(id).mapToDomain()
    }
}