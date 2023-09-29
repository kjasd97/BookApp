package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class BookListEntryDto(
    @SerializedName("books") val books: List<BookDto>
)
