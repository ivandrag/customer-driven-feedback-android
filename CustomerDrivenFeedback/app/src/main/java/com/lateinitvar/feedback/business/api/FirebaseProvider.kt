package com.lateinitvar.feedback.business.api

import com.google.firebase.auth.FirebaseAuth
import com.lateinitvar.feedback.business.model.User
import kotlinx.coroutines.tasks.await

class FirebaseProvider {

    suspend fun signInWithEmailAndPassword(email: String, password: String): User {
        val auth = FirebaseAuth.getInstance()
        val authResult = auth.signInWithEmailAndPassword(email, password).await()
        val user = authResult.user
        return User(user?.uid, user?.email, user?.displayName)
    }
}
