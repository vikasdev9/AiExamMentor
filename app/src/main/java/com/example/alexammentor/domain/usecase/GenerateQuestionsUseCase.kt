package com.example.alexammentor.domain.usecase

import com.example.alexammentor.domain.model.Question
import com.example.alexammentor.domain.repository.AiRepository
import javax.inject.Inject

class GenerateQuestionsUseCase @Inject constructor(
    private val repository: AiRepository
) {
    suspend operator fun invoke(content: String, count: Int, difficulty: String): List<Question> {
        return repository.generateQuestions(content, count, difficulty)
    }
}
