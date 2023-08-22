package com.publicis.interview

import android.content.Context
import androidx.lifecycle.ViewModel
import com.publicis.interview.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.json.Json

class MainViewModel(private val context: Context): ViewModel() {

    val books: MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())

    init {
        fetch()
    }

    fun fetch() {
        context.resources.assets.open("books.json")
            .bufferedReader()
            .use { it.readText() }
            .let { Json.decodeFromString<List<Book>>(it) }
            .run { books.tryEmit(this) }
    }
}