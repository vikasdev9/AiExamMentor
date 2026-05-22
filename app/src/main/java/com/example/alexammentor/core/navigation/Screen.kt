package com.example.alexammentor.core.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object OCR : Screen("ocr")
    object QuestionGen : Screen("question_gen")
    object Quiz : Screen("quiz")
    object Subscription : Screen("subscription")
}
