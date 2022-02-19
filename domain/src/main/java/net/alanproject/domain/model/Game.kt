package net.alanproject.domain.model

data class Game(
    val id: Int = 0,
    val name: String = "",
    val nameOriginal: String = "",
    val description: String = "",
    val metacritic: Int = 0,
    val released: String = "",
    val backgroundImage: String = "",
    val backgroundImageAdditional: String = "",
    val rating: Double = 0.0,
    val added: Int = 0,
    val playtime: Int = 0,
    val developers: List<Developer> = listOf(),
    val genres: List<Genre> = listOf(),
    val tags: List<Tag> = listOf(),
    val publishers: List<Publisher> = listOf(),
    val esrbRating: String = "",
    val descriptionRaw: String = ""
)
data class Developer(
    val id: Int = 0,
    val name: String = "",
    val slug: String = ""
)
data class Publisher(
    val id: Int = 0,
    val name: String = "",
    val slug: String = ""
)
