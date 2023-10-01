package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data  class CategoriesDto (
    @SerializedName("list_name") val listName:String,
    @SerializedName("oldest_published_date") val oldestPublishedDate: String,
    @SerializedName("newest_published_date") val newestPublishedDate: String


)