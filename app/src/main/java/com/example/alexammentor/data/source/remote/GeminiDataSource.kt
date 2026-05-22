package com.example.alexammentor.data.source.remote

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.example.alexammentor.BuildConfig
import com.example.alexammentor.core.common.AiPrompts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeminiDataSource @Inject constructor() {

    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = BuildConfig.GEMINI_API_KEY
    )

    suspend fun generateQuestions(content: String, count: Int, difficulty: String): String? = withContext(Dispatchers.IO) {
        try {
            val response = generativeModel.generateContent(
                AiPrompts.generateQuestionPrompt(content, count, difficulty)
            )
            response.text
        } catch (e: Exception) {
            null
        }
    }
}
