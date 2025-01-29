package com.example.proyectoequipo3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tuapp.data.repository.FirebaseAuthRepository

class loginViewModel: ViewModel() {


    private val authRepository = FirebaseAuthRepository()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _registerResult = MutableLiveData<String?>()
    val registerResult: LiveData<String?> get() = _registerResult

}