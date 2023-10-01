package com.ulyanenko.bookapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "categories")
data class CategoryEntity(

    @PrimaryKey
    val listName: String,

    val oldestPublishedDate: String,

    val newestPublishedDate: String
) : Serializable {

}