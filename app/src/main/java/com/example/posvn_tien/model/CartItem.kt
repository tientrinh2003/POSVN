package com.example.posvn_tien.model

data class CartItem(
    val name: String,
    val price: Double,
    var quantity: Int,
    val imageResource: Int
)
