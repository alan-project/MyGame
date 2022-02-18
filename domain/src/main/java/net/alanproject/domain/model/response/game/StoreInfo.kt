package net.alanproject.domain.model.response.game


data class StoreInfo(
    val id: Int = 0,
    val url: String = "",
    val store: Store = Store()
)