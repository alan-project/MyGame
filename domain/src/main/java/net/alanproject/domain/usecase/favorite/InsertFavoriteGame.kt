package net.alanproject.domain.usecase.favorite

import net.alanproject.domain.model.Game

interface InsertFavoriteGame {

    suspend fun insert(
        game:Game
    )
}