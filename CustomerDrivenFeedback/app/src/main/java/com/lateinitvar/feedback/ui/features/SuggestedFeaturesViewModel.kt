package com.lateinitvar.feedback.ui.features

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.model.SuggestedFeature
import com.lateinitvar.feedback.business.usecase.FeatureUseCase
import kotlinx.coroutines.launch

class SuggestedFeaturesViewModel(
    private val featureUseCase: FeatureUseCase
) : ViewModel() {

    private val _onEvent = MutableLiveData<OnEvent>()

    val onEvent: LiveData<OnEvent>
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