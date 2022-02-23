package net.alanproject.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import net.alanproject.domain.model.Game
import net.alanproject.domain.model.GameInfo
import net.alanproject.domain.util.Resource

interface GetAllFavoriteGames {
    suspend fun get(): Flow<List<GameInfo>>
}