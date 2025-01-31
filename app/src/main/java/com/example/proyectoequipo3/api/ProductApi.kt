package com.example.proyectoequipo3.api

import com.example.proyectoequipo3.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getAllProducts(): Response<List<Product>>
}
