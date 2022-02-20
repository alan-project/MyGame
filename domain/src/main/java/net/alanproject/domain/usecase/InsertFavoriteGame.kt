package net.alanproject.domain.usecase

import net.alanproject.domain.model.Game

interface InsertFavoriteGame {

    suspend fun insert(
        game:Game
    )
}