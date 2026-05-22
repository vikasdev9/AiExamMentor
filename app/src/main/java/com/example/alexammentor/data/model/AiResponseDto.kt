package com.example.alexammentor.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AiResponseDto(
    val mcqs: List<McqDto> = emptyList(),
    val fillBlanks: List<FillBlankDto> = emptyList(),
    val trueFalse: List<TrueFalseDto> = emptyList()
)

@Serializable
data class McqDto(
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
    val explanation: String,
    val difficulty: String
)

@Serializable
data class FillBlankDto(
    val question: String,
    val correctAnswer: String,
    val explanation: String
)

@Serializable
data class TrueFalseDto(
    val question: String,
    val correctAnswer: Boolean,
    val explanation: String
)
