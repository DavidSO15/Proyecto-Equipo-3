package com.example.tuapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


    fun registerUser(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        Log.d("FirebaseAuth", "Intentando registrar usuario: $email")

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FirebaseAuth", "Registro exitoso: ${firebaseAuth.currentUser?.uid}")
                    callback(true, null)
                } else {
                    Log.e("FirebaseAuth", "Error en registro: ${task.exception?.message}")
                    callback(false, task.exception?.message)
                }
            }
    }


    fun login(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        Log.d("FirebaseAuth", "Intentando iniciar sesión: $email")

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FirebaseAuth", "Inicio de sesión exitoso: ${firebaseAuth.currentUser?.uid}")
                    callback(true, null)
                } else {
                    Log.e("FirebaseAuth", "Error en inicio de sesión: ${task.exception?.message}")
                    callback(false, task.exception?.message)
                }
            }
    }
}
