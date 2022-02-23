package net.alanproject.mygame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.alanproject.domain.usecase.favorite.DeleteFavoriteGame
import net.alanproject.domain.usecase.favorite.GetAllFavoriteGames
import net.alanproject.domain.usecase.favorite.InsertFavoriteGame
import net.alanproject.domain.usecase.favorite.impl.DeleteFavoriteGameUsecase
import net.alanproject.domain.usecase.favorite.impl.GetAllFavoriteGamesUsecase
import net.alanproject.domain.usecase.favorite.impl.InsertFavoriteGameUsecase
import net.alanproject.domain.usecase.game.GetGame
import net.alanproject.domain.usecase.game.GetGames
import net.alanproject.domain.usecase.game.impl.GetGameUsecase
import net.alanproject.domain.usecase.game.impl.GetGamesUsecase

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