package com.lateinitvar.feedback.business.repository

import com.lateinitvar.feedback.business.datasource.LoginRemoteDataSource

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    val currentUser = loginRemoteDataSource.currentUser ?: throw Exception("No available current user")

    suspend fun signInWithEmailAndPassword(email: String, password: String) =
        loginRemoteDataSource.signInWithEmailAndPassword(email, password)

    suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        loginRemoteDataSource.createUserWithEmailAndPassword(email, password)
}
