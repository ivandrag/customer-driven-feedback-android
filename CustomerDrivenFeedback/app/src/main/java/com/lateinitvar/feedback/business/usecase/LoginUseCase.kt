package com.lateinitvar.feedback.business.usecase

import com.lateinitvar.feedback.business.repository.LoginRepository

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    val currentUser = loginRepository.currentUser

    suspend fun signInWithEmailAndPassword(email: String, password: String) =
        loginRepository.signInWithEmailAndPassword(email, password)

    suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        loginRepository.createUserWithEmailAndPassword(email, password)
}
