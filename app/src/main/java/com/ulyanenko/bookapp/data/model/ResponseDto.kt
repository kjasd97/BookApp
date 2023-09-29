package com.ulyanenko.bookapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseDto (
    @SerializedName("results") val results: List<CategoriesDto>
)