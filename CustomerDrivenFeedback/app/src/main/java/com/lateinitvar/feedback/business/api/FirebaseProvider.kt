package com.lateinitvar.feedback.business.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lateinitvar.feedback.business.model.SuggestedFeature
import com.lateinitvar.feedback.business.model.User
import kotlinx.coroutines.tasks.await
import java.util.UUID

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

    suspend fun getAllSuggestedFeatures(): List<SuggestedFeature> {
        val allSuggestedFeatures = mutableListOf<SuggestedFeature>()
        Firebase.firestore
            .collection("suggested-features")
            .whereEqualTo("key", "fsOOOeNyT8as3o91wuxh0mKWD1k2")
            .get()
            .addOnSuccessListener {
                it.documents.map { documentSnapshot ->
                    allSuggestedFeatures.add(
                        SuggestedFeature(
                            documentSnapshot["id"] as String,
                            documentSnapshot["key"] as String,
                            documentSnapshot["title"] as String,
                            documentSnapshot["description"] as String,
                            documentSnapshot["totalVotes"] as Long,
                            documentSnapshot["hasVoted"] as List<String>
                        )
                    )
                }
            }.await()

        return allSuggestedFeatures
    }

    suspend fun submitSuggestion(title: String, description: String) {
        val feature = hashMapOf(
            "key" to "fsOOOeNyT8as3o91wuxh0mKWD1k2",
            "id" to UUID.randomUUID().toString(),
            "title" to title,
            "description" to description,
            "totalVotes" to 0,
            "hasVoted" to emptyList<String>()
        )
        Firebase.firestore
            .collection("suggested-features")
            .document()
            .set(feature)
            .await()
    }

    suspend fun updateTotalVotes(suggestedFeatureId: String, userId: String) {
        val collection = Firebase.firestore
            .collection("suggested-features")

        collection.whereEqualTo("id", suggestedFeatureId)
            .get()
            .addOnCompleteListener { querySnapshot ->
                if (querySnapshot.isSuccessful) {
                    querySnapshot.result?.forEach {
                        val hasVotedList = it["hasVoted"] as MutableList<String>
                        hasVotedList.add(userId)
                        val featureUpdateMap = hashMapOf(
                            "hasVoted" to hasVotedList.distinct()
                        )
                        collection.document(it.id).set(featureUpdateMap, SetOptions.merge())
                    }
                }
            }
            .await()
    }
}
