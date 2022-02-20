package net.alanproject.data.repository.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val released: String = "",
    val backgroundImage: String = "",
    val rating: Double = 0.0,
    val added: Int = 0,
    val metacritic: Int = 0,
    val playtime: Int = 0,
    val esrbRating: String = ""
): Serializable
