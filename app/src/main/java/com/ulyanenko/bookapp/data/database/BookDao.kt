package com.ulyanenko.bookapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ulyanenko.bookapp.domain.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books:List<BookEntity>)

    @Query("SELECT * FROM books WHERE category = :listName")
    suspend fun getBooksForCategory(listName: String): List<Book>

}