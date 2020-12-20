package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    suspend fun signUpWithEmailAndPassword(email: String, password: String) =
        loginRemoteDataSource.signUpWithEmailAndPassword(email, password)
}
