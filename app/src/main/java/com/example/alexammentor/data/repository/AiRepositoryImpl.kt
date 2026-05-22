package com.example.alexammentor.data.repository

import com.example.alexammentor.data.model.AiResponseDto
import com.example.alexammentor.data.source.remote.GeminiDataSource
import com.example.alexammentor.domain.model.*
import com.example.alexammentor.domain.repository.AiRepository
import kotlinx.serialization.json.Json
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AiRepositoryImpl @Inject constructor(
    private val geminiDataSource: GeminiDataSource
) : AiRepository {

    private val json = Json { 
        ignoreUnknownKeys = true 
        coerceInputValues = true
    }

    override suspend fun generateQuestions(content: String, count: Int, difficulty: String): List<Question> {
        val rawResponse = geminiDataSource.generateQuestions(content, count, difficulty) ?: return emptyList()
        
        // Clean JSON response (AI sometimes wraps it in markdown)
        val cleanJson = rawResponse.substringAfter("```json").substringBefore("```").trim()
        val finalJson = if (cleanJson.isEmpty()) rawResponse.trim() else cleanJson

        return try {
            val dto = json.decodeFromString<AiResponseDto>(finalJson)
            val questions = mutableListOf<Question>()
            
            val mappedDifficulty = when(difficulty.uppercase()) {
                "EASY" -> Difficulty.EASY
                "HARD" -> Difficulty.HARD
                else -> Difficulty.MEDIUM
            }

            dto.mcqs.mapTo(questions) {
                MCQ(
                    id = UUID.randomUUID().toString(),
                    questionText = it.question,
                    options = it.options,
                    correctAnswer = it.correctAnswer,
                    explanation = it.explanation,
                    difficulty = mappedDifficulty
                )
            }
            
            dto.fillBlanks.mapTo(questions) {
                FillInTheBlank(
                    id = UUID.randomUUID().toString(),
                    questionText = it.question,
                    correctAnswer = it.correctAnswer,
                    explanation = it.explanation,
                    difficulty = mappedDifficulty
                )
            }
            
            dto.trueFalse.mapTo(questions) {
                TrueFalse(
                    id = UUID.randomUUID().toString(),
                    questionText = it.question,
                    correctAnswer = it.correctAnswer,
                    explanation = it.explanation,
                    difficulty = mappedDifficulty
                )
            }
            
            questions
        } catch (e: Exception) {
            emptyList()
        }
    }
}
