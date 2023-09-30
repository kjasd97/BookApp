package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("title") val name:String,
    @SerializedName("description") val description: String,
    @SerializedName("author") val author: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("book_image") val bookImage: String,
    @SerializedName("amazon_product_url") val amazonProductUrl: String

    )
