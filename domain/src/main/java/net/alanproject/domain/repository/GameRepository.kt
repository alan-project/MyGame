package net.alanproject.domain.repository

import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.util.Parameters

interface GameRepository {

    suspend fun getGames(
        parameters: Parameters
    ): Games

}