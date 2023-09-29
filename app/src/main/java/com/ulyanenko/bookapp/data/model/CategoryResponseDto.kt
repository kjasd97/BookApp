package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponseDto (
    @SerializedName("results") val results: List<CategoriesDto>
)