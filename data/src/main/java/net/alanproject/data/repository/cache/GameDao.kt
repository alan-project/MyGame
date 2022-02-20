package net.alanproject.data.repository.cache

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: GameEntity)

    @Query("DELETE FROM games WHERE id = :gameId")
    suspend fun delete(gameId: Int)

    @Query("SELECT * FROM games")
    fun getAll(): Flow<List<GameEntity>>

    @Query("DELETE FROM games")
    suspend fun deleteAll()
}