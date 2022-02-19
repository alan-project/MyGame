package net.alanproject.domain.model



data class Games(
    val count: Int? = 0,
    val next: String? = "",
    val results: List<GameInfo>? = listOf(),
)

data class GameInfo(
    val id: Int = 0,
    val name: String = "",
    val released: String? = "",
    val image: String? = "",
    val rating: Double? = 0.0,
    val added: Int? = 0,
    val metacritic: Int? = 0,
    val playtime: Int? = 0,
    val suggestionsCount: Int? = 0,
    val genres: List<Genre>? = listOf(),
    val tags: List<Tag>? = listOf(),
    val esrbRating: String? = "",
)
