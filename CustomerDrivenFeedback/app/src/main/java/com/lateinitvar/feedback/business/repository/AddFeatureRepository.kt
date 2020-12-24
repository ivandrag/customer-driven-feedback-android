package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.AddFeatureRemoteDataSource

class AddFeatureRepository(private val addFeatureRemoteDataSource: AddFeatureRemoteDataSource) {

    suspend fun submitSuggestion(title: String, description: String) {
        addFeatureRemoteDataSource.submitSuggestion(title, description)
    }
}
