package net.alanproject.data.source

import net.alanproject.domain.model.Game
import net.alanproject.domain.model.Games

interface GameSource {
    suspend fun getGames(
        page:Int?,
        ordering:String?,
        dates:String?,
        platforms:String?,
        genres:String?
    ): Games

    suspend fun getGame(
        id:Int
    ): Game

}