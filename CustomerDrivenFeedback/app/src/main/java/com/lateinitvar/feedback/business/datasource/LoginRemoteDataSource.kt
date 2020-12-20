package com.lateinitvar.feedback.business.datasource

import com.lateinitvar.feedback.business.api.FirebaseProvider
import com.lateinitvar.feedback.business.model.User

class LoginRemoteDataSource(
    private val firebaseProvider: FirebaseProvider
) {

    suspend fun signInWithEmailAndPassword(email: String, password: String) =
        firebaseProvider.signInWithEmailAndPassword(email, password)

    suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        firebaseProvider.createUserWithEmailAndPassword(email, password)
}
