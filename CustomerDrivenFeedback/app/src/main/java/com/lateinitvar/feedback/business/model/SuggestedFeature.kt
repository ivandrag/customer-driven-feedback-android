package com.lateinitvar.feedback.business.model

data class SuggestedFeature(
    val id: String,
    val key: String,
    val title: String,
    val description: String,
    val totalVotes: Long,
    val hasVoted: List<String>
)
