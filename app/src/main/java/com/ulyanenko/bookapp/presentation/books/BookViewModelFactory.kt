package com.ulyanenko.bookapp.presentation.books

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookViewModelFactory(private val category:String,private val application: Application):  ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(category, application) as T
    }
}
