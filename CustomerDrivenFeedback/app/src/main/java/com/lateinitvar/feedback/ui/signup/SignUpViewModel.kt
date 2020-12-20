package com.lateinitvar.feedback.ui.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lateinitvar.feedback.business.usecase.LoginUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun signUp(email: String?, password: String?) = viewModelScope.launch {
        when {
            email.isNullOrEmpty() -> ""
            password.isNullOrEmpty() -> ""
            else -> {
                runCatching {
                    loginUseCase.createUserWithEmailAndPassword(email, password)
                }.onSuccess {

                }.onFailure {

                }
            }
        }
    }
}
