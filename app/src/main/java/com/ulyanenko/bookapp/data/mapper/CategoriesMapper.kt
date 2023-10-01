package com.ulyanenko.bookapp.data.mapper

import com.ulyanenko.bookapp.data.model.CategoriesDto
import com.ulyanenko.bookapp.domain.Category

class CategoriesMapper {

    fun mapResponseToCategories(categoriesDto: List<CategoriesDto>): List<Category> {

        val result = mutableListOf<Category>()

        for(categoryDto in categoriesDto){
            val category = Category(
                listName = categoryDto.listName,
                oldestPublishedDate =  categoryDto.oldestPublishedDate,
                newestPublishedDate = categoryDto.newestPublishedDate
            )
            result.add(category)
        }
        return result
    }
}