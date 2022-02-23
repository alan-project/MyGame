package net.alanproject.domain.usecase.game

import net.alanproject.domain.model.Game
import net.alanproject.domain.util.Resource

interface GetGame {

    suspend fun get(
        id:Int
    ): Resource<Game>
}
