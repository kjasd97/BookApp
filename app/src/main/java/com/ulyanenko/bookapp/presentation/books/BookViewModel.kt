package com.ulyanenko.bookapp.presentation.books

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulyanenko.bookapp.data.database.AppDataBase
import com.ulyanenko.bookapp.data.database.BookDao
import com.ulyanenko.bookapp.data.database.BookEntity
import com.ulyanenko.bookapp.data.mapper.BookMapper
import com.ulyanenko.bookapp.data.network.ApiFactory
import com.ulyanenko.bookapp.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(category: String, application: Application) : ViewModel() {

    private val _books: MutableStateFlow<List<Book>?> = MutableStateFlow(null)
    val books: StateFlow<List<Book>?> = _books

    private val bookDao: BookDao by lazy {
        AppDataBase.getInstance(application).bookDao()
    }

    private val mapper = BookMapper()

    init {
        viewModelScope.launch {
            try {
                loadBooksFromDatabase(category)
            } catch (e: Exception) {
                Log.d("loadBooksFromDatabase", e.message.toString())
            }
        }

    }

    private suspend fun loadBooksFromDatabase(category: String) {
        val cachedBooks = bookDao.getBooksForCategory(category).map {
            Book(
                it.name,
                it.description,
                it.author,
                it.publisher,
                it.rank,
                it.bookImage,
                it.amazonProductUrl
            )
        }
        if (cachedBooks.isNotEmpty()) {
            _books.value = cachedBooks
        } else {
            loadBooks(category)
        }
    }

    private suspend fun loadBooks(category: String) {

        val response = ApiFactory.apiService.loadBooks(category).results.lists
        val books = mapper.mapResponseToBook(response)

        val bookEntity = books.map {
            BookEntity(
                it.name,
                it.description,
                it.author,
                it.publisher,
                it.rank,
                it.bookImage,
                it.amazonProductUrl,
                category
            )
        }
        bookDao.insertBooks(bookEntity)

        _books.value = books

    }


//    fun loadBooks(category: String) {
//        viewModelScope.launch {
//            val response = ApiFactory.apiService.loadBooks(category).results.lists
//            val booksFromNetwork = mapper. mapResponseToBook (response)
//            _books.value = booksFromNetwork
//        }
//    }


}