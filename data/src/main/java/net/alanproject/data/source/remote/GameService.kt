package net.alanproject.data.source.remote

import net.alanproject.data.BuildConfig
import net.alanproject.domain.model.response.games.Games
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int? =1 ,
        @Query("ordering") order: String? = "-added", // rating, release, metacritic
        @Query("dates") dates: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("genres") genres: String? = null,
    ): Games
}