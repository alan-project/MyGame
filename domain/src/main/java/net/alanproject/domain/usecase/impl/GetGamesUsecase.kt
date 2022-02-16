package net.alanproject.domain.usecase.impl

import net.alanproject.domain.util.Resource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.GetGames
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGamesUsecase @Inject constructor(
    private val gameRepository: GameRepository
) : GetGames {
    override suspend fun get(
        page: Int?,
        ordering: String?,
        dates: String?,
        platforms: String?,
        genres: String?
    ): Resource<Games> {
        val response = try {
            gameRepository.getGames(
                page = page,
                ordering = ordering,
                dates = dates,
                platforms = platforms,
                genres = genres
            )
        } catch (exception: Exception) {
            Timber.e("exception: $exception")
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}
