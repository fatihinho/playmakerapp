package com.fcinar.playmakerapp.service

import android.content.ContentValues
import android.util.Log
import com.fcinar.playmakerapp.entity.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class UserService {

    private val db = Firebase.firestore

    fun saveUser(user: User, authUID: String) {
        db.collection("users")
            .document(authUID)
            .set(user)
            .addOnSuccessListener {
                Log.d(ContentValues.TAG, "User added with ID: $authUID")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}