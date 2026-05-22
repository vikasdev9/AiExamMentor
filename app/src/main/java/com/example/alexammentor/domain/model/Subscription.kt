package com.example.alexammentor.domain.model

data class UserSubscription(
    val userId: String,
    val tier: SubscriptionTier,
    val expiryDate: Long?,
    val aiCreditsRemaining: Int
)

enum class SubscriptionTier {
    FREE, PREMIUM, ENTERPRISE
}

object SubscriptionLimits {
    const val FREE_DAILY_GENERATIONS = 3
    const val FREE_OCR_SCANS = 5
    const val PREMIUM_GENERATIONS = Int.MAX_VALUE
}
