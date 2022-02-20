package net.alanproject.data.common

import net.alanproject.data.model.game.GameResp
import net.alanproject.data.model.games.GamesResp
import net.alanproject.data.repository.cache.GameEntity
import net.alanproject.domain.model.*

fun Game.mapToData(): GameEntity = GameEntity(
    id = id,
    name = name,
    metacritic = metacritic,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    added = added,
    playtime = playtime,
    esrbRating = esrbRating,
)

fun GameEntity.mapToDomain(): GameInfo = GameInfo(
    id = id,
    name = name,
    metacritic = metacritic,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    added = added,
    playtime = playtime,
    esrbRating = esrbRating,
)


fun GamesResp.mapToDomain(): Games = Games(
    count = count,
    next = next,
    results = results.map { gameInfoResp ->
        GameInfo(
            id = gameInfoResp.id,
            name = gameInfoResp.name,
            released = gameInfoResp.released,
            backgroundImage = gameInfoResp.backgroundImage,
            rating = gameInfoResp.rating,
            added = gameInfoResp.added,
            metacritic = gameInfoResp.metacritic,
            playtime = gameInfoResp.playtime,
            esrbRating = gameInfoResp.esrbRating?.name.orEmpty()
        )
    }
)


fun GameResp.mapToDomain(): Game = Game(
    id = this.id,
    name = name,
    nameOriginal = nameOriginal,
    description = description,
    metacritic = metacritic,
    released = released,
    backgroundImage = backgroundImage,
    backgroundImageAdditional = backgroundImageAdditional,
    rating = rating,
    added = added,
    playtime = playtime,

    developers = developers.map { developer ->
        Developer(
            id = developer.id,
            name = developer.name,
            slug = developer.slug
        )
    },
    genres = genres.map { genre ->
        Genre(
            id = genre.id,
            name = genre.name,
            slug = genre.slug
        )
    },
    tags = tags.map { tag ->
        Tag(
            id = tag.id,
            name = tag.name,
            slug = tag.slug,
            language = tag.language

        )
    },
    publishers = publishers.map { publisher ->
        Publisher(
            id = publisher.id,
            name = publisher.name,
            slug = publisher.slug
        )
    },

    esrbRating = esrbRating?.name.orEmpty(),
    descriptionRaw = descriptionRaw
)