package com.lateinitvar.feedback.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.AddFeatureUseCase
import kotlinx.coroutines.launch

class AddFeatureViewModel(
    private val addFeatureUseCase: AddFeatureUseCase
): ViewModel() {

    private val _onEvent = MutableLiveData<OnEvent>()

    val onEvent : LiveData<OnEvent>
        get() = _onEvent

    fun submitSuggestion(title: String?, description: String?) = viewModelScope.launch {
        when {
            title.isNullOrEmpty() -> ""
            description.isNullOrEmpty() -> ""
            else -> {
                runCatching {
                    addFeatureUseCase.submitSuggestion(title, description)
                }.onSuccess {
                    _onEvent.postValue(OnEvent.SuggestFeatureSuccessfully)
                    // Show success message or something
                }.onFailure {
                    // Show error message if suggestion cannot be submitted.
                }
            }
        }
    }

    sealed class OnEvent {
        object SuggestFeatureSuccessfully: OnEvent()
    }
}
