package net.alanproject.domain.model.response.game


data class MetacriticPlatform(
    val metascore: Int = 0,
    val url: String = "",
    val platform: Platform = Platform()
)