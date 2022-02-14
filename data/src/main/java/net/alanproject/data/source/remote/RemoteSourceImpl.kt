package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.games.Games
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSourceImpl @Inject constructor(
    private val gameService:GameService
):RemoteSource {
    override suspend fun getGames(): Games {
        return gameService.getGames()
    }
}