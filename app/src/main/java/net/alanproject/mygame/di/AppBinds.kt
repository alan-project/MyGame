package net.alanproject.mygame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecase.GetGame
import net.alanproject.domain.usecase.GetGames
import net.alanproject.domain.usecase.impl.GetGameUsecase
import net.alanproject.domain.usecase.impl.GetGamesUsecase

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecases {

    @Binds
    abstract fun bindGetGames(getGames: GetGamesUsecase): GetGames

    @Binds
    abstract fun bindGetGame(getGame: GetGameUsecase): GetGame


}