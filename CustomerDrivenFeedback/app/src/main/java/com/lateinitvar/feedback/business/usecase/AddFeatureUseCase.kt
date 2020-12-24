package com.lateinitvar.feedback.business.usecase

import com.lateinitvar.feedback.business.repository.AddFeatureRepository

class AddFeatureUseCase(
    private val addFeatureRepository: AddFeatureRepository
) {

    suspend fun submitSuggestion(title: String, description: String) {
        addFeatureRepository.submitSuggestion(title, description)
    }
}

