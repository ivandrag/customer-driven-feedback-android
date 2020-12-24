package com.lateinitvar.feedback.business.api

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lateinitvar.feedback.business.model.User
import kotlinx.coroutines.tasks.await

class FirebaseProvider {

    fun getCurrentUser() = FirebaseAuth.getInstance().currentUser

    suspend fun signInWithEmailAndPassword(email: String, password: String): User {
        val auth = FirebaseAuth.getInstance()
        val authResult = auth.signInWithEmailAndPassword(email, password).await()
        val user = authResult.user
        return User(user?.uid, user?.email, user?.displayName)
    }

    suspend fun createUserWithEmailAndPassword(email: String, password: String): User {
        val auth = FirebaseAuth.getInstance()
        val authResult = auth.createUserWithEmailAndPassword(email, password).await()
        val user = authResult.user
        return User(user?.uid, user?.email, user?.displayName)
    }

    suspend fun getAllSuggestedFeatures() {
        val firestore = Firebase.firestore
        val documents = firestore
            .collection("suggested-features")
            .document("fsOOOeNyT8as3o91wuxh0mKWD1k2")
            .collection("all-features")
            .get()
            .await()
        for (document in documents) {
            Log.d("##RESULT " , document.data.toString())
        }
    }
}
