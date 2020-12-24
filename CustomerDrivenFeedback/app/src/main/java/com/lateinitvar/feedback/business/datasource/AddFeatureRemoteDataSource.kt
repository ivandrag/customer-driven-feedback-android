package com.lateinitvar.feedback.business.datasource

import com.lateinitvar.feedback.business.api.FirebaseProvider

class AddFeatureRemoteDataSource(private val firebaseProvider: FirebaseProvider) {

    suspend fun submitSuggestion(title: String, description: String) {
        firebaseProvider.submitSuggestion(title, description)
    }
}
