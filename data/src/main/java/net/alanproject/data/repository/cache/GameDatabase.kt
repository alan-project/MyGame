package net.alanproject.data.repository.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class],version = 1)
abstract class GameDatabase:RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var instance: GameDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GameDatabase::class.java,
                "article_db.db"
            ).build()
    }
}