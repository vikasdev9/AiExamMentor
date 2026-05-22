package com.example.alexammentor.domain.model

sealed class Question(
    open val id: String,
    open val questionText: String,
    open val explanation: String?,
    open val difficulty: Difficulty
)

data class MCQ(
    override val id: String,
    override val questionText: String,
    val options: List<String>,
    val correctAnswer: String,
    override val explanation: String?,
    override val difficulty: Difficulty
) : Question(id, questionText, explanation, difficulty)

data class TrueFalse(
    override val id: String,
    override val questionText: String,
    val correctAnswer: Boolean,
    override val explanation: String?,
    override val difficulty: Difficulty
) : Question(id, questionText, explanation, difficulty)

data class FillInTheBlank(
    override val id: String,
    override val questionText: String,
    val correctAnswer: String,
    override val explanation: String?,
    override val difficulty: Difficulty
) : Question(id, questionText, explanation, difficulty)

data class DescriptiveQuestion(
    override val id: String,
    override val questionText: String,
    val sampleAnswer: String,
    override val explanation: String?,
    override val difficulty: Difficulty,
    val isShort: Boolean
) : Question(id, questionText, explanation, difficulty)

enum class Difficulty {
    EASY, MEDIUM, HARD
}
