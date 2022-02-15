package net.alanproject.data.source.remote

import net.alanproject.data.source.RemoteSource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.util.Parameters
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSourceImpl @Inject constructor(
    private val gameService: GameService
) : RemoteSource {

    override suspend fun getGames(
        parameters: Parameters
    ): Games {
        Timber.d(
            "page: ${parameters.page}, order:${parameters.ordering}, dates: ${parameters.period}, platforms:${parameters.platforms}, genres:${parameters.genres}"
        )
        return gameService.getGames(
            page = parameters.page,
            order = parameters.ordering,
            dates = parameters.period,
            platforms = parameters.platforms,
            genres = parameters.genres
        )
    }
}