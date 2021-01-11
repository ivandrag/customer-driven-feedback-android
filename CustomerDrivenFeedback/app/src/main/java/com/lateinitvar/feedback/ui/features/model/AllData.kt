package com.lateinitvar.feedback.ui.features.model

import com.lateinitvar.feedback.business.model.SuggestedFeature

data class AllData(
    val userId: String,
    val suggestedFeatureList: List<SuggestedFeature>
)
