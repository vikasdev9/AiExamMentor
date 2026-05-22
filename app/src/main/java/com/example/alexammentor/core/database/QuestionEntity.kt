package com.example.alexammentor.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey val id: String,
    val type: String, // MCQ, TF, FIB, DESC
    val questionText: String,
    val options: String?, // JSON string for MCQs
    val correctAnswer: String,
    val explanation: String?,
    val difficulty: String,
    val createdAt: Long = System.currentTimeMillis()
)
