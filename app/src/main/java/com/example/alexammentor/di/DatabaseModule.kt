package com.example.alexammentor.di

import android.content.Context
import androidx.room.Room
import com.example.alexammentor.core.database.AppDatabase
import com.example.alexammentor.core.database.QuestionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "alexammentor_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideQuestionDao(db: AppDatabase): QuestionDao {
        return db.questionDao
    }
}
