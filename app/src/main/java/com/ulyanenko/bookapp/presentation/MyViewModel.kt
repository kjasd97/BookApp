package com.ulyanenko.bookapp.presentation


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulyanenko.bookapp.data.mapper.CategoriesMapper
import com.ulyanenko.bookapp.data.network.ApiFactory
import com.ulyanenko.bookapp.domain.Category
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    var categories: List<Category>? by mutableStateOf(null)
        private set

    val mapper = CategoriesMapper()

    init {
    loadCategories()
    }

    fun loadCategories() {
        viewModelScope.launch {
            val response = ApiFactory.apiService.loadCategories().results
            val categoriesFromNetwork = mapper.mapResponseToCategories(response)
            Log.d("test777", categoriesFromNetwork.toString())
            categories = categoriesFromNetwork
        }
    }

}