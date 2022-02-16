package net.alanproject.domain.usecase

import net.alanproject.domain.util.Resource
import net.alanproject.domain.model.response.games.Games

interface GetGames {
    suspend fun get(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Resource<Games>
}