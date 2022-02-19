package net.alanproject.data.model.games


import com.google.gson.annotations.SerializedName

data class Filters(
    val years: List<Year> = listOf()
)