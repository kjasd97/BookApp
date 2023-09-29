package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class BookResponseDto (
    @SerializedName("results") val results: BookListDto
)