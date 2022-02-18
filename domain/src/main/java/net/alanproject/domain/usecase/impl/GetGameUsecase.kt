package net.alanproject.domain.usecase.impl

import net.alanproject.domain.model.response.game.Game
import net.alanproject.domain.model.response.games.Games
import net.alanproject.domain.repository.GameRepository
import net.alanproject.domain.usecase.GetGame
import net.alanproject.domain.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGameUsecase @Inject constructor(
    private val gameRepository: GameRepository
):GetGame {
    override suspend fun get(id: Int): Resource<Game> {
        val response = try{
            gameRepository.getGame(id)
        }catch(exception:Exception){
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }
}