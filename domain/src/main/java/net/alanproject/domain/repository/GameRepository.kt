package net.alanproject.domain.repository

import net.alanproject.domain.model.Game
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

}