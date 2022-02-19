package net.alanproject.data.model.game


data class MetacriticPlatform(
    val metascore: Int = 0,
    val url: String = "",
    val platform: Platform = Platform()
)