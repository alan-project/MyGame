package net.alanproject.domain.usecase.impl

import net.alanproject.domain.common.Resource
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.GetGames
import java.lang.Exception

class GetGamesUsecase(
    private val gameRepository: GameRepository
):GetGames {
    override suspend fun get(): Resource<Games> {
        val response = try {
            gameRepository.getGames()
        }catch(exception:Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}