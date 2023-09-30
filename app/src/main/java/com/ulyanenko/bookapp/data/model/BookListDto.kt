package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class BookListDto (
    @SerializedName("books") val lists: List<BookDto>
)