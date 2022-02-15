package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.util.Parameters
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val remoteSource:RemoteSource
):GameRepository {


    override suspend fun getGames(
        parameters: Parameters
    ): Games {
        return remoteSource.getGames(parameters)
    }
}