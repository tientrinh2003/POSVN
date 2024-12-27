package com.example.posvn_tien.data

import com.example.posvn_tien.R
import com.example.posvn_tien.model.CartItem

object CartDataProvider {
    val defaultCartList = CartItem("", -1.0,1, R.drawable.hamcheese);
    val cartList = mutableListOf<CartItem>()
    fun updateCartList(cartItem: CartItem){
        if(cartList.contains(cartItem)){
            // If the item name already exists, update the previous same item quantity +1
        } else {
            cartList.add(cartItem)
        }
    }
}