package com.ulyanenko.bookapp.data.mapper

import com.ulyanenko.bookapp.data.model.BookDto
import com.ulyanenko.bookapp.data.model.CategoriesDto
import com.ulyanenko.bookapp.domain.Book
import com.ulyanenko.bookapp.domain.Category

class BookMapper {

    fun mapResponseToBook(booksDto: List<BookDto>): List<Book> {

        val result = mutableListOf<Book>()

        for (bookDto in booksDto) {
            val book = Book(
                name = bookDto.name,
                author = bookDto.author,
                description = bookDto.description,
                publisher = bookDto.publisher,
                rank = bookDto.rank
                )
            result.add(book)
        }
        return result
    }

}