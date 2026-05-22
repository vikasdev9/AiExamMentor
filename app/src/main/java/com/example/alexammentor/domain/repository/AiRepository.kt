package com.example.alexammentor.domain.repository

import com.example.alexammentor.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface AiRepository {
    suspend fun generateQuestions(content: String, count: Int, difficulty: String): List<Question>
}
