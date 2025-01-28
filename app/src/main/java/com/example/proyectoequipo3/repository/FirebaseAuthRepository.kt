package com.example.tuapp.data.repository

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true, null)
                } else {
                    callback(false, task.exception?.message)
                }
            }
    }
}

