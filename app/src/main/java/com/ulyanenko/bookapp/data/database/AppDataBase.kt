package com.ulyanenko.bookapp.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CategoryEntity::class, BookEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun bookDao(): BookDao


    companion object {

        private var database: AppDataBase? = null

        fun getInstance(application: Application): AppDataBase {

            database?.let {
                return it
            }

            val db = Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                "book_app_db"
            ).build()

            database = db

            return database as AppDataBase
        }
    }

}