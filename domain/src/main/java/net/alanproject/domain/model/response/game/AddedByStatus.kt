package net.alanproject.domain.model.response.game


import com.google.gson.annotations.SerializedName

data class AddedByStatus(
    val yet: Int = 0,
    val owned: Int = 0,
    val beaten: Int = 0,
    val toplay: Int = 0,
    val dropped: Int = 0,
    val playing: Int = 0
)