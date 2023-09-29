package com.ulyanenko.bookapp.data.network

import com.ulyanenko.bookapp.data.model.CategoriesDto
import com.ulyanenko.bookapp.data.model.ResponseDto
import retrofit2.http.GET

interface ApiService {

    @GET("lists/names.json?api-key=T2LEjxGYLMW7O0GpJype8rh3rT3ToHnF")
    suspend fun loadCategories():ResponseDto


}