package com.example.tuapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.android.gms.tasks.Task

class FirebaseAuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true, null)  // Registro exitoso
                } else {
                    callback(false, task.exception?.message)  // Error en el registro
                }
            }
    }

    fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}
