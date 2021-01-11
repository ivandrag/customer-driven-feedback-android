package com.lateinitvar.feedback.business.usecase

import com.lateinitvar.feedback.business.repository.FeatureRepository

class FeatureUseCase(
    private val featureRepository: FeatureRepository
) {
    suspend fun getAllSuggestedFeatures() = featureRepository.getAllSuggestedFeatures()

    suspend fun upVote(id: String) {
        featureRepository.upVote(id)
    }
}
