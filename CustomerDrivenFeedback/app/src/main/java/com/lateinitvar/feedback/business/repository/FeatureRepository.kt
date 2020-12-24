package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.FeatureRemoteDataSource

class FeatureRepository(
    private val featureRemoteDataSource: FeatureRemoteDataSource
) {
    suspend fun getAllSuggestedFeatures() = featureRemoteDataSource.getAllSuggestedFeatures()
}
