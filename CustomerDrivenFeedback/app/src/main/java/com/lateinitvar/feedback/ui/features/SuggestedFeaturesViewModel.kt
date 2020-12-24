package com.lateinitvar.feedback.ui.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.model.SuggestedFeature
import com.lateinitvar.feedback.business.usecase.FeatureUseCase
import com.lateinitvar.feedback.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class SuggestedFeaturesViewModel(
    private val featureUseCase: FeatureUseCase
) : ViewModel() {

    private val _onEvent = SingleLiveEvent<OnEvent>()

    val onEvent: SingleLiveEvent<OnEvent>
        get() = _onEvent

    fun getAllSuggestedFeatures() = viewModelScope.launch {
        runCatching {
            featureUseCase.getAllSuggestedFeatures()
        }.onSuccess { allSuggestedFeatures ->
            _onEvent.postValue(OnEvent.AllSuggestedFeatures(allSuggestedFeatures))
        }.onFailure {

        }
    }

    sealed class OnEvent {
        data class AllSuggestedFeatures(val allSuggestedFeatures: List<SuggestedFeature>) : OnEvent()
    }
}