package com.ulyanenko.bookapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ulyanenko.bookapp.presentation.books.BookScreen
import com.ulyanenko.bookapp.presentation.categories.CategoriesList
import com.ulyanenko.bookapp.presentation.webview.WebViewPage

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "categories") {

        composable("categories") {
            CategoriesList(
                onCategoryClickListener = { category ->
                    navController.navigate("books/${category.listName}")
                }
            )
        }

        composable(
            route = "books/{categoryListName}",
            arguments = listOf(navArgument("categoryListName") { type = NavType.StringType })
        ) { backStackEntry ->
            val listName = backStackEntry.arguments?.getString("categoryListName") ?: ""
            BookScreen(listName,navController)
        }

        composable(
            route = "web_view/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            WebViewPage(url = url)
        }

    }
}