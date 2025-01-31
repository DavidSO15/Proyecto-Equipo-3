package com.example.proyectoequipo3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tuapp.data.repository.FirebaseAuthRepository

class loginViewModel : ViewModel() {

    private val authRepository = FirebaseAuthRepository()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _loginResult = MutableLiveData<String?>()
    val loginResult: LiveData<String?> get() = _loginResult


    fun loginUser(email: String, password: String) {
        _isLoading.value = true
        authRepository.login(email, password) { success, message ->
            _isLoading.value = false
            if (success) {
                _loginResult.value = "Inicio de sesión exitoso"
            } else {
                _loginResult.value = message ?: "Error desconocido"
            }
        }
    }
}
