package com.ulyanenko.bookapp.domain

import com.google.gson.annotations.SerializedName

data class Book(
    val name: String,
    val description: String,
    val author: String,
    val publisher: String,
    val rank: Int,
    @SerializedName("book_image") val bookImage: String
)
