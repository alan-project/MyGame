package net.alanproject.domain.model.response.game


import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("3")
    val x3: Int = 0,
    @SerializedName("7")
    val x7: Int = 0,
    @SerializedName("8")
    val x8: Int = 0,
    @SerializedName("12")
    val x12: Int = 0,
    @SerializedName("14")
    val x14: Int = 0,
    @SerializedName("15")
    val x15: Int = 0,
    @SerializedName("16")
    val x16: Int = 0
)