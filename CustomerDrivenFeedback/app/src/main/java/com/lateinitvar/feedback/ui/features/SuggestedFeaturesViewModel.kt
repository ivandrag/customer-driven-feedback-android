package com.lateinitvar.feedback.ui.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.FeatureUseCase
import kotlinx.coroutines.launch

class SuggestedFeaturesViewModel(
    private val featureUseCase: FeatureUseCase
) : ViewModel() {

    fun getAllSuggestedFeatures() = viewModelScope.launch {
        runCatching {
            featureUseCase.getAllSuggestedFeatures()
        }.onSuccess {

        }.onFailure {

        }
    }
}