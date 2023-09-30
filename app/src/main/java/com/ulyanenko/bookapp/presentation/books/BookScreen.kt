package com.ulyanenko.bookapp.presentation.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.ulyanenko.bookapp.domain.Book
import com.ulyanenko.bookapp.presentation.categories.CategoryCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookScreen(category: String) {

    val viewModel: BookViewModel = viewModel(
        factory = BookViewModelFactory(category)
    )
    val books = viewModel.books.collectAsState()

    Scaffold(

    ) { paddingValues ->
        if (books.value != null) {
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 72.dp
                )
            ) {
                items(books.value!!) {
                    BookItem(book = it)
                }
            }
        } else {
            Text(text = "Loading books...")
        }
    }
}

@Composable
private fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row (modifier = Modifier.padding(16.dp)){
            AsyncImage(
                model = book.bookImage,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "Name is: ${book.name}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Author: ${book.author}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Description: ${book.description}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Publisher: ${book.publisher}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Rank: ${book.rank}",
                    fontSize = 14.sp
                )


            }
        }

    }
}