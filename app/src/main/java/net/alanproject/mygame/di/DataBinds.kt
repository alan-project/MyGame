package net.alanproject.mygame.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.data.source.GameSource
import net.alanproject.data.source.remote.GameService
import net.alanproject.data.source.remote.GameSourceImpl
import net.alanproject.mygame.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class Source {

    @Binds
    abstract fun bindRemoteSource(remoteSource: GameSourceImpl): GameSource
}


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
}