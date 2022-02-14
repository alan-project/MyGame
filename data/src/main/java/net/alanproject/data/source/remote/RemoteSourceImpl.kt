package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.games.Games

class RemoteSourceImpl(
    private val gameService:GameService
):RemoteSource {
    override suspend fun getGames(): Games {
        return gameService.getGames()
    }
}