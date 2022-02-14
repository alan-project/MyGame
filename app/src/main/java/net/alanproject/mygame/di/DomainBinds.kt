package net.alanproject.mygame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.data.repository.GameRepositoryImpl
import net.alanproject.domain.repository.GameRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecase {

    @Binds
    abstract fun bindRepository(gameRepository: GameRepositoryImpl): GameRepository
}