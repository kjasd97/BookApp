package com.ulyanenko.bookapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val listName: String,
    val oldestPublishedDate: String,
    val newestPublishedDate: String
):Parcelable
