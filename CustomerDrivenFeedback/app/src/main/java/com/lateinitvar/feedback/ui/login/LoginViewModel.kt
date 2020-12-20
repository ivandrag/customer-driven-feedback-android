package com.lateinitvar.feedback.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lateinitvar.feedback.business.usecase.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _onEvent = MutableLiveData<String>()

    val onEvent : LiveData<String>
        get() = _onEvent

    fun login(email: String, password: String) {
        _onEvent.value = "Good Morning"
    }
}
