package net.alanproject.data.model.games


import com.google.gson.annotations.SerializedName
import net.alanproject.domain.model.Games

data class GamesResp(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = Any(),
    val results: List<GameInfoResp> = listOf(),
    @SerializedName("seo_title")
    val seoTitle: String = "",
    @SerializedName("seo_description")
    val seoDescription: String = "",
    @SerializedName("seo_keywords")
    val seoKeywords: String = "",
    @SerializedName("seo_h1")
    val seoH1: String = "",
    val noindex: Boolean = false,
    val nofollow: Boolean = false,
    val description: String = "",
    val filters: Filters = Filters(),
    @SerializedName("nofollow_collections")
    val nofollowCollections: List<String> = listOf()
)

fun GamesResp.mapToDomain(): Games = Games(
    count = count,
    next = next,
    results = results.map { gameInfoResp->
        net.alanproject.domain.model.GameInfo(
            id = gameInfoResp.id,
            name = gameInfoResp.name,
            released = gameInfoResp.released,
            image = gameInfoResp.backgroundImage,
            rating = gameInfoResp.rating,
            added = gameInfoResp.added,
            metacritic = gameInfoResp.metacritic,
            playtime = gameInfoResp.playtime,
            suggestionsCount = gameInfoResp.suggestionsCount,
            genres = gameInfoResp.genres.map { genre ->
                net.alanproject.domain.model.Genre(
                    id = genre.id,
                    name = genre.name,
                    slug = genre.slug
                )
            },
            tags = gameInfoResp.tags.map { tag ->
                net.alanproject.domain.model.Tag(
                    id = tag.id,
                    name = tag.name,
                    slug = tag.slug,
                    language = tag.language
                )
            },
            esrbRating = gameInfoResp.esrbRating?.name.orEmpty()
        )
    }
)


