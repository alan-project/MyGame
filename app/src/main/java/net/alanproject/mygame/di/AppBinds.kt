package net.alanproject.mygame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecase.*
import net.alanproject.domain.usecase.impl.*

@Module
@InstallIn(SingletonComponent::class)
abstract class Usecases {

    @Binds
    abstract fun bindGetGames(getGames: GetGamesUsecase): GetGames

    @Binds
    abstract fun bindGetGame(getGame: GetGameUsecase): GetGame

    @Binds
    abstract fun bindInsertFavoriteGame(insertFavoriteGame: InsertFavoriteGameUsecase): InsertFavoriteGame


    @Binds
    abstract fun bindDeleteFavoriteGame(deleteFavoriteGame: DeleteFavoriteGameUsecase): DeleteFavoriteGame

    @Binds
    abstract fun bindGetAllFavoriteGame(getAllFavoriteGames: GetAllFavoriteGamesUsecase): GetAllFavoriteGames


}