package com.lateinitvar.feedback.business.usecase

import com.lateinitvar.feedback.business.repository.LoginRepository

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun signUpWithEmailAndPassword(email: String, password: String) =
        loginRepository.signUpWithEmailAndPassword(email, password)
}
