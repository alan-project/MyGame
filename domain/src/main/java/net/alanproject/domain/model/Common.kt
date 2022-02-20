package net.alanproject.domain.model

data class Genre(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
)


data class Tag(
    val id: Int = 0,
    val name: String = "",
    val slug: String = "",
    val language: String = "",
)
