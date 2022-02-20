package net.alanproject.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.model.Games

interface GameRepository {

    suspend fun getGames(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Games

    suspend fun getGame(
        id: Int,
    ): Game

    suspend fun insertFavoriteGame(
        game:Game
    )

    suspend fun deleteFavoriteGame(
        gameId:Int
    )

    suspend fun deleteAllFavoriteGame()

    fun getAllFavoriteGames(): Flow<List<GameInfo>>

}