package net.alanproject.domain.usecase.favorite

interface DeleteFavoriteGame {
    suspend fun delete(
        gameId:Int
    )
}