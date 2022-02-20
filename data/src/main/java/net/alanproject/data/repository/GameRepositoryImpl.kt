package net.alanproject.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.alanproject.data.common.mapToData
import net.alanproject.data.common.mapToDomain
import net.alanproject.data.repository.cache.GameDao
import net.alanproject.data.repository.cache.GameDatabase
import net.alanproject.data.repository.remote.GameService
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.model.Games
import net.alanproject.domain.repository.GameRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val gameService: GameService,
    private val db: GameDatabase
) : GameRepository {

    override suspend fun getGames(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Games {
        return gameService.getGames(
            page = page,
            ordering = ordering,
            dates = dates,
            platforms = platforms,
            genres = genres
        ).mapToDomain()
    }

    override suspend fun getGame(id: Int): Game {
        return gameService.getGame(id).mapToDomain()
    }

    override suspend fun insertFavoriteGame(game: Game) {
        db.gameDao().insert(game.mapToData())
    }

    override suspend fun deleteFavoriteGame(gameId: Int) {
        db.gameDao().delete(gameId)
    }

    override suspend fun deleteAllFavoriteGame() {
        db.gameDao().deleteAll()
    }

    override fun getAllFavoriteGames(): Flow<List<GameInfo>> {
        val gameInfoList =  db.gameDao().getAll().map { gameEntities ->
            gameEntities.map { gameEntity ->
                gameEntity.mapToDomain()
            }
        }
        Timber.d("[favorite] result: $gameInfoList")
        return gameInfoList

    }

}