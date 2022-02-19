package net.alanproject.domain.usecase

import net.alanproject.domain.model.Games
import net.alanproject.domain.util.Resource

interface GetGames {
    suspend fun get(
        page: Int?=1,
        ordering: String? = "-added",
        dates: String? = null,
        platforms: String? = null,
        genres: String? = null
    ): Resource<Games>
}