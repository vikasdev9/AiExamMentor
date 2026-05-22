package com.example.alexammentor.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuestionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val questionDao: QuestionDao
}
