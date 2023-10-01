package com.ulyanenko.bookapp.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.ulyanenko.bookapp.domain.Category

@Entity(
    tableName = "books",
    primaryKeys = ["name", "category"],
    indices = [Index(value = ["name", "category"], unique = true)]
)
data class BookEntity(

    val name: String,

    val description: String,

    val author: String,

    val publisher: String,

    val rank: Int,

    val bookImage: String,

    val amazonProductUrl: String,

    val category: String

) {
}