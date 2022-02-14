package net.alanproject.data.source

import net.alanproject.domain.model.response.games.Games

interface RemoteSource {
    suspend fun getGames(): Games

}