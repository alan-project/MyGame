package net.alanproject.data.source

import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.util.Parameters

interface RemoteSource {
    suspend fun getGames(parameters: Parameters): Games

}