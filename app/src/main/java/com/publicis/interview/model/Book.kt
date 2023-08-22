package com.publicis.interview.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val title: String,
    val price: Int,
    val type: String,
    val coverUrl: String,
    val synopsis: List<String>
) {

    var priceDisplay = String.format("%.2f€", price.toDouble() / 100)
}
