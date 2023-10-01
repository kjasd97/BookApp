package com.ulyanenko.bookapp.presentation.categories

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulyanenko.bookapp.data.database.AppDataBase
import com.ulyanenko.bookapp.data.database.CategoryDao
import com.ulyanenko.bookapp.data.database.CategoryEntity
import com.ulyanenko.bookapp.data.mapper.CategoriesMapper
import com.ulyanenko.bookapp.data.network.ApiFactory
import com.ulyanenko.bookapp.domain.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) :  AndroidViewModel(application) {


    private val _categories: MutableStateFlow<List<Category>?> = MutableStateFlow(null)
    val categories: StateFlow<List<Category>?> = _categories

    private val categoryDao: CategoryDao by lazy {
        AppDataBase.getInstance(application).categoryDao()
    }

    val mapper = CategoriesMapper()

    init {
        viewModelScope.launch {
            try {
                loadCategoriesFromDataBase()
            }catch (e: Exception){
                Log.d("loadCategoriesFromDataBase", e.message.toString())
            }
        }

    }


    private suspend fun loadCategoriesFromDataBase() {
            val listOfCategories = categoryDao.getCategories().map {
                Category(
                    it.listName,
                    it.newestPublishedDate,
                    it.oldestPublishedDate
                )
            }
            if (listOfCategories.isNotEmpty()) {
                _categories.value = listOfCategories
            } else {
                loadCategoriesFromNetwork()
            }

    }

    private suspend fun loadCategoriesFromNetwork() {

            val response = ApiFactory.apiService.loadCategories().results
            val categoriesFromNetwork = mapper.mapResponseToCategories(response)
            _categories.value = categoriesFromNetwork

            val categoriesEntities = categoriesFromNetwork.map {

                CategoryEntity(
                    it.listName,
                    it.newestPublishedDate,
                    it.oldestPublishedDate
                )

            }
            categoryDao.insertCategories(categoriesEntities)


    }


}