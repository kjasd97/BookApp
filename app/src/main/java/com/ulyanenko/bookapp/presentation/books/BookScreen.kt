package com.ulyanenko.bookapp.presentation.books

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ulyanenko.bookapp.domain.Book
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookScreen(category: String, navController: NavController) {

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
                    BookItem(book = it, navController)
                }
            }
        } else {
            Text(text = "Loading books...")
        }
    }
}

@Composable
private fun BookItem(book: Book, navController: NavController) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                AsyncImage(
                    model = book.bookImage,
                    modifier = Modifier
                        .size(100.dp),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Rank: ${book.rank}",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 25.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = book.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Author: ${book.author}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Publisher: ${book.publisher}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Description: ${book.description}",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Click to buy!",
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        val encodedUrl = URLEncoder.encode(
                            book.amazonProductUrl,
                            StandardCharsets.UTF_8.toString()
                        )
                        navController.navigate("web_view/${encodedUrl}")
                    }
                )


            }
        }

    }
}



