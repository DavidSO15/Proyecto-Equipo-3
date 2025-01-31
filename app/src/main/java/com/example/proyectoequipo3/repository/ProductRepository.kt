package com.example.proyectoequipo3.repository

import com.example.proyectoequipo3.api.RetrofitInstance
import com.example.proyectoequipo3.model.Product

class ProductRepository {

    // Función para obtener todos los productos de la API
    suspend fun getProducts(): List<Product>? {
        // Realiza la llamada a la API usando Retrofit
        val response = RetrofitInstance.api.getAllProducts()
        // Retorna los datos si la respuesta es exitosa y no nula, de lo contrario retorna null
        return if (response.isSuccessful && response.body() != null) {
            response.body()
        } else {
            null
        }
    }
}
