package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    suspend fun signInWithEmailAndPassword(email: String, password: String) =
        loginRemoteDataSource.signInWithEmailAndPassword(email, password)

    suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        loginRemoteDataSource.createUserWithEmailAndPassword(email, password)
}
