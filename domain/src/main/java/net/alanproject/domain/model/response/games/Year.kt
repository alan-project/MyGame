package net.alanproject.domain.model.response.games


import com.google.gson.annotations.SerializedName

data class Year(
    val from: Int = 0,
    val to: Int = 0,
    val filter: String = "",
    val decade: Int = 0,
    val years: List<YearX> = listOf(),
    val nofollow: Boolean = false,
    val count: Int = 0
)