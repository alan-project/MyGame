package net.alanproject.domain.model.response.games


import com.google.gson.annotations.SerializedName

data class Filters(
    val years: List<Year> = listOf()
)