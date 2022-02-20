package net.alanproject.mygame.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.alanproject.data.repository.cache.GameDatabase
import net.alanproject.data.repository.remote.GameService
import net.alanproject.mygame.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object DomainProvides {

    @Provides
    fun provideService(): GameService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameService::class.java)
    }

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): GameDatabase {
        return Room.databaseBuilder(
            appContext,
            GameDatabase::class.java,
            "article_db.db"
        ).build()
    }
}