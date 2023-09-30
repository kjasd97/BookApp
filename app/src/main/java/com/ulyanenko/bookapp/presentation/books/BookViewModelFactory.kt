package com.ulyanenko.bookapp.presentation.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookViewModelFactory(private val category:String):  ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(category) as T
    }
}
