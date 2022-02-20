package net.alanproject.domain.usecase

interface DeleteFavoriteGame {
    suspend fun delete(
        gameId:Int
    )
}