package com.lateinitvar.feedback.business.datasource

import com.lateinitvar.feedback.business.api.FirebaseProvider

class FeatureRemoteDataSource(
    private val firebaseProvider: FirebaseProvider
) {

    suspend fun getAllSuggestedFeatures() = firebaseProvider.getAllSuggestedFeatures()

    suspend fun upVote(id: String, userId: String) {
        firebaseProvider.updateTotalVotes(suggestedFeatureId = id, userId = userId)
    }
}