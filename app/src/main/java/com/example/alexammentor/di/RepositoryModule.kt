package com.example.alexammentor.di

import com.example.alexammentor.data.repository.AiRepositoryImpl
import com.example.alexammentor.domain.repository.AiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAiRepository(
        aiRepositoryImpl: AiRepositoryImpl
    ): AiRepository
}
