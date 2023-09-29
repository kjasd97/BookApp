package com.ulyanenko.bookapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ulyanenko.bookapp.domain.Category
import com.ulyanenko.bookapp.ui.theme.BookAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAppTheme {
                CategoriesList()
            }
        }
    }
}

@Composable
fun CategoriesList(myViewModel: MyViewModel = viewModel()) {

    val categories = myViewModel.categories

    if (categories != null) {
        LazyColumn {

            items(categories) { category ->
                CategoryCard(category = category)
            }
        }
    } else {
        Text(text = "Loading categories...")
    }

}

@Composable
fun CategoryCard(category: Category) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Column() {
                Text(
                    text = "Category: ${category.listName}",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Oldest published date: ${category.oldestPublishedDate}",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Newest published date: ${category.newestPublishedDate}",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif
                )
            }
        }

    }
}