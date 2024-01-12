package com.fcinar.playmakerapp.service

import android.content.ContentValues.TAG
import android.util.Log
import com.fcinar.playmakerapp.entity.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class UserService {

    private val db = Firebase.firestore

    fun saveUser(user: User) {
        db.collection("users")
            .document(user.username)
            .set(user)
            .addOnSuccessListener {
                Log.i(TAG, "${user.username} added with ID: ${user.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}