package com.ulyanenko.bookapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ulyanenko.bookapp.domain.Category

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories:List<CategoryEntity>)


    @Query("SELECT * FROM categories")
    suspend fun getCategories(): List<CategoryEntity>
}