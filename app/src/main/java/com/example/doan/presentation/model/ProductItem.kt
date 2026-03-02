package com.example.doan.presentation.model

data class ProductItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Float,
    val imageUrl: String,
    val isFavorite: Boolean = false
)

