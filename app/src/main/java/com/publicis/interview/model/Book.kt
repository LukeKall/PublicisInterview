package com.publicis.interview.model

data class Book(
    val isbn: ISBN,
    val title: String,
    val price: Int,
    val coverUrl: String,
    val synopsis: List<String>
) {
    @JvmInline
    value class ISBN(val value: String)
}
