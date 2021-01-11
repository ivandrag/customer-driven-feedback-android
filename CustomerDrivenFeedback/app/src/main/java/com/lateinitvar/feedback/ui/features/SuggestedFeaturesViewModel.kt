package com.lateinitvar.feedback.ui.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.FeatureUseCase
import com.lateinitvar.feedback.ui.features.model.AllData
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
        }.onSuccess { allData ->
            _onEvent.postValue(OnEvent.AllSuggestedFeatures(allData))
        }.onFailure {

        }
    }

    fun upVote(id: String) = viewModelScope.launch {
        runCatching {
            featureUseCase.upVote(id)
        }.onSuccess {
            _onEvent.postValue(OnEvent.OnUpVoteSuccess)
        }.onFailure {

        }
    }

    sealed class OnEvent {
        data class AllSuggestedFeatures(val allData: AllData) : OnEvent()
        object OnUpVoteSuccess: OnEvent()
    }
}