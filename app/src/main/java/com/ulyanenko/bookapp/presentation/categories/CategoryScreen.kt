package com.ulyanenko.bookapp.presentation.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ulyanenko.bookapp.domain.Book
import com.ulyanenko.bookapp.domain.Category


@Composable
fun CategoriesList(onCategoryClickListener: (Category) -> Unit) {

    val myViewModel: CategoryViewModel = viewModel()
    val categories = myViewModel.categories

    if (categories != null) {
        LazyColumn {

            items(categories) { category ->
                CategoryCard(category = category,onCategoryClickListener )
            }
        }
    } else {
        Text(text = "Loading categories...")
    }

}

@Composable
fun CategoryCard(category: Category, onCategoryClickListener: (Category) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onCategoryClickListener(category)
            }
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