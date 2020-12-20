package com.lateinitvar.feedback.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.LoginUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun signUp(email: String, password: String) = viewModelScope.launch {
        runCatching {
            loginUseCase.signUpWithEmailAndPassword(email, password)
        }.onSuccess {

        }.onFailure {

        }
    }
}
