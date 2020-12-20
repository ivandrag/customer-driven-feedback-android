package com.lateinitvar.feedback.ui.login

import androidx.lifecycle.ViewModel
import com.lateinitvar.feedback.business.usecase.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    fun login(email: String, password: String) {

    }
}
