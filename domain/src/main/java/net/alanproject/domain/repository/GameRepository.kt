package net.alanproject.domain.repository

import net.alanproject.domain.model.response.games.Games

interface GameRepository {

    suspend fun getGames(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Games

}