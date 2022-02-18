package net.alanproject.domain.model.response.game


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    val id: Int = 0,
    val name: String = "",
    val slug: String = ""
)