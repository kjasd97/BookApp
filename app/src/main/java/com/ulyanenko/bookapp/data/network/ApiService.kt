package com.ulyanenko.bookapp.data.network

import com.ulyanenko.bookapp.data.model.BookResponseDto
import com.ulyanenko.bookapp.data.model.CategoryResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("lists/names.json?api-key=T2LEjxGYLMW7O0GpJype8rh3rT3ToHnF")
    suspend fun loadCategories(): CategoryResponseDto

    @GET("lists/overview.json?api-key=T2LEjxGYLMW7O0GpJype8rh3rT3ToHnF")
    suspend fun loadBooks(@Query("list_name") listName: String): BookResponseDto


//    @GET("lists/overview.json?list_name={list_name}&api-key=T2LEjxGYLMW7O0GpJype8rh3rT3ToHnF")
//    suspend fun loadBooks(@Path("list_name") listName: String): BookResponseDto


}