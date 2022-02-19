package net.alanproject.data.source.remote

import net.alanproject.data.BuildConfig
import net.alanproject.data.model.game.GameResp
import net.alanproject.data.model.games.GamesResp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int?,
        @Query("ordering") ordering: String?, // rating, release, metacritic
        @Query("dates") dates: String?,
        @Query("platforms") platforms: String?,
        @Query("genres") genres: String?,
    ): GamesResp

    @GET("games/{id}")
    suspend fun getGame(
        @Path("id") id: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): GameResp
}