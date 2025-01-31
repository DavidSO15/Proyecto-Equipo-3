package com.example.proyectoequipo3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoequipo3.model.Product
import com.example.proyectoequipo3.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = repository.getProducts()
            _products.value = response
            _isLoading.value = false
        }
    }
}
