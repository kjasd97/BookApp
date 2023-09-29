package com.ulyanenko.bookapp.domain

import com.google.gson.annotations.SerializedName

data class Category(
    val listName: String,
    val oldestPublishedDate: String?,
    val newestPublishedDate: String?
)
