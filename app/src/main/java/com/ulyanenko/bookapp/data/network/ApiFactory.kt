package com.ulyanenko.bookapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiFactory {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com/svc/books/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService:ApiService = retrofit.create()
}