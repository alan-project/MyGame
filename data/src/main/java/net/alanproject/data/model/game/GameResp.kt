package net.alanproject.data.model.game


import com.google.gson.annotations.SerializedName
import net.alanproject.domain.model.Game

data class GameResp(
    val id: Int = 0,
    val slug: String = "",
    val name: String = "",
    @SerializedName("name_original")
    val nameOriginal: String = "",
    val description: String = "",
    val metacritic: Int = 0,
    @SerializedName("metacritic_platforms")
    val metacriticPlatforms: List<MetacriticPlatform> = listOf(),
    val released: String = "",
    val tba: Boolean = false,
    val updated: String = "",
    @SerializedName("background_image")
    val backgroundImage: String = "",
    @SerializedName("background_image_additional")
    val backgroundImageAdditional: String = "",
    val website: String = "",
    val rating: Double = 0.0,
    @SerializedName("rating_top")
    val ratingTop: Int = 0,
    val ratings: List<Rating> = listOf(),
    val reactions: Reactions = Reactions(),
    val added: Int = 0,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatus = AddedByStatus(),
    val playtime: Int = 0,
    @SerializedName("screenshots_count")
    val screenshotsCount: Int = 0,
    @SerializedName("movies_count")
    val moviesCount: Int = 0,
    @SerializedName("creators_count")
    val creatorsCount: Int = 0,
    @SerializedName("achievements_count")
    val achievementsCount: Int = 0,
    @SerializedName("parent_achievements_count")
    val parentAchievementsCount: Int = 0,
    @SerializedName("reddit_url")
    val redditUrl: String = "",
    @SerializedName("reddit_name")
    val redditName: String = "",
    @SerializedName("reddit_description")
    val redditDescription: String = "",
    @SerializedName("reddit_logo")
    val redditLogo: String = "",
    @SerializedName("reddit_count")
    val redditCount: Int = 0,
    @SerializedName("twitch_count")
    val twitchCount: Int = 0,
    @SerializedName("youtube_count")
    val youtubeCount: Int = 0,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int = 0,
    @SerializedName("ratings_count")
    val ratingsCount: Int = 0,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int = 0,
    @SerializedName("alternative_names")
    val alternativeNames: List<Any> = listOf(),
    @SerializedName("metacritic_url")
    val metacriticUrl: String = "",
    @SerializedName("parents_count")
    val parentsCount: Int = 0,
    @SerializedName("additions_count")
    val additionsCount: Int = 0,
    @SerializedName("game_series_count")
    val gameSeriesCount: Int = 0,
    @SerializedName("user_game")
    val userGame: Any = Any(),
    @SerializedName("reviews_count")
    val reviewsCount: Int = 0,
    @SerializedName("saturated_color")
    val saturatedColor: String = "",
    @SerializedName("dominant_color")
    val dominantColor: String = "",
    @SerializedName("parent_platforms")
    val parentPlatformInfos: List<ParentPlatformInfo> = listOf(),
    val platforms: List<PlatformInfo> = listOf(),
    val storeInfos: List<StoreInfo> = listOf(),
    val developers: List<Developer> = listOf(),
    val genres: List<Genre> = listOf(),
    val tags: List<Tag> = listOf(),
    val publishers: List<Publisher> = listOf(),
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRating = EsrbRating(),
    val clip: Any = Any(),
    @SerializedName("description_raw")
    val descriptionRaw: String = ""
)

fun GameResp.mapToDomain():Game = Game(
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

    developers = developers.map{developer->
        net.alanproject.domain.model.Developer(
            id = developer.id,
            name = developer.name,
            slug = developer.slug
        )
    },
    genres = genres.map{ genre->
      net.alanproject.domain.model.Genre(
          id = genre.id,
          name = genre.name,
          slug = genre.slug
      )
    },
    tags = tags.map{tag->
        net.alanproject.domain.model.Tag(
            id = tag.id,
            name = tag.name,
            slug = tag.slug,
            language = tag.language

        )
    },
    publishers = publishers.map{publisher->
        net.alanproject.domain.model.Publisher(
            id = publisher.id,
            name = publisher.name,
            slug = publisher.slug
        )
    },

    esrbRating = esrbRating.name,
    descriptionRaw = descriptionRaw,
)
