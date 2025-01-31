package com.example.proyectoequipo3.model

data class Product(
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double
)
