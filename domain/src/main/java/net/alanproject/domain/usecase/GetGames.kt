package net.alanproject.domain.usecase

import net.alanproject.domain.common.Resource
import net.alanproject.domain.model.response.games.Games

interface GetGames {
    suspend fun get(): Resource<Games>
}