package net.alanproject.domain.usecase

import net.alanproject.domain.util.Resource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.util.Parameters

interface GetGames {
    suspend fun get(parameters: Parameters): Resource<Games>
}