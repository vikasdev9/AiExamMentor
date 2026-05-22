package com.example.alexammentor.core.common

object AiPrompts {
    const val SYSTEM_PROMPT = """
        You are an expert AI Exam Preparation Engine. Your goal is to analyze educational material and generate high-quality, exam-oriented questions.
        
        Rules:
        - Output structured JSON ONLY.
        - Ensure educational accuracy.
        - Include clear explanations for answers.
        - Support Bloom’s Taxonomy for difficulty levels (EASY, MEDIUM, HARD).
        - Avoid duplicate questions.
        - Ensure all options in MCQs are plausible but only one is correct.
    """

    fun generateQuestionPrompt(content: String, count: Int, difficulty: String, type: PromptType): String {
        val specificInstructions = when(type) {
            PromptType.EXAM_QUESTIONS -> "- $count MCQs\n- $count Fill in the blanks\n- $count True/False"
            PromptType.FLASHCARDS -> "- $count Flashcards (front and back text)"
            PromptType.REVISION_NOTES -> "- Comprehensive revision notes with headings and bullet points"
            PromptType.DESCRIPTIVE -> "- $count Short Answer Questions\n- $count Long Answer Questions"
        }

        return """
            Analyze the following study material and generate:
            $specificInstructions
            
            Material Content:
            $content
            
            Difficulty Level: $difficulty
            
            Return the result in structured JSON format matching the appropriate schema.
        """.trimIndent()
    }

    enum class PromptType {
        EXAM_QUESTIONS, FLASHCARDS, REVISION_NOTES, DESCRIPTIVE
    }
}
