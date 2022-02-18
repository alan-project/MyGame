package net.alanproject.domain.model.response.game


import com.google.gson.annotations.SerializedName

data class PlatformInfo(
    val platform: Platform = Platform(),
    @SerializedName("released_at")
    val releasedAt: String = "",
    val requirements: Requirements = Requirements()
)