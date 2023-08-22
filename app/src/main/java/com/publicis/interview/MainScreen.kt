package com.publicis.interview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        mainViewModel.books.collectAsState(emptyList()).value.forEach {
            Row {
                Image(painter = rememberAsyncImagePainter(model = it.coverUrl), contentDescription = null)
                Column {
                    Text(text = it.title)
                    Text(text = it.synopsis.joinToString("\n"))
                    //TODO set specific genre icons :Icons.Default.Call, Icons.Default.Edit, Icons.Default.Lock
                    Text(text = it.priceDisplay)
                }
            }
        }
    }
}