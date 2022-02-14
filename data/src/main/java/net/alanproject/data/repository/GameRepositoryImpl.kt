package net.alanproject.data.repository

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.repository.GameRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    private val remoteSource:RemoteSource
):GameRepository {
    override suspend fun getGames(): Games  = remoteSource.getGames()
}