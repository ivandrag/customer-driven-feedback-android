package com.lateinitvar.feedback.business.datasource

import com.lateinitvar.feedback.business.api.FirebaseProvider
import com.lateinitvar.feedback.business.model.User

class LoginRemoteDataSource(
    private val firebaseProvider: FirebaseProvider
) {

    suspend fun signUpWithEmailAndPassword(email: String, password: String) =
        firebaseProvider.signInWithEmailAndPassword(email, password)
}
