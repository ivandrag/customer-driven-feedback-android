package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.FeatureRemoteDataSource
import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource
import com.lateinitvar.feedback.ui.features.model.AllData

class FeatureRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val featureRemoteDataSource: FeatureRemoteDataSource
) {
    suspend fun getAllSuggestedFeatures(): AllData {
        val allSuggestedFeatures = featureRemoteDataSource.getAllSuggestedFeatures()
        val userId = loginRemoteDataSource.currentUser?.uid ?: ""
        return AllData(userId, allSuggestedFeatures)
    }

    suspend fun upVote(id: String) {
        val userId =
            loginRemoteDataSource.currentUser?.uid ?: throw Exception("No available user id")
        featureRemoteDataSource.upVote(id, userId)
    }
}
