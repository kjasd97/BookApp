package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class BookListDto (
    @SerializedName("lists") val lists: List<BookListEntryDto>
)