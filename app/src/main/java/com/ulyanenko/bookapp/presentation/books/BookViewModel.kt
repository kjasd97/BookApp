package com.ulyanenko.bookapp.presentation.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulyanenko.bookapp.data.mapper.BookMapper
import com.ulyanenko.bookapp.data.network.ApiFactory
import com.ulyanenko.bookapp.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(category: String): ViewModel() {

    private val _books: MutableStateFlow<List<Book>?> = MutableStateFlow(null)
    val books: StateFlow<List<Book>?> = _books



    private val mapper = BookMapper()

    init {
        loadBooks(category)
    }

    fun loadBooks(category: String) {
        viewModelScope.launch {
            val response = ApiFactory.apiService.loadBooks(category).results.lists.flatMap { it.books }
            val booksFromNetwork = mapper. mapResponseToBook (response)
            _books.value = booksFromNetwork
        }
    }


}