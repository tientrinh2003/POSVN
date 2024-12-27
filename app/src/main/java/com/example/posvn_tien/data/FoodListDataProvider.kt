package com.example.posvn_tien.data

import android.accounts.Account
import com.example.posvn_tien.R
import com.example.posvn_tien.model.FoodItem

/**
 * An static data store of [Account]s. This includes both [Account]s owned by the current user and
 * all [Account]s of the current user's contacts.
 */
object FoodListDataProvider {
    val defaultFoodList = FoodItem("", -1.0, R.drawable.hamcheese);
    val foodlist = listOf(
        FoodItem("Cheese burger", 8.24, R.drawable.hamcheese),
        FoodItem("Fries", 3.50, R.drawable.hamcheese), // Changed image resource to "fries"
        FoodItem("Pizza", 12.99, R.drawable.hamcheese),
        FoodItem("Pasta", 10.50, R.drawable.hamcheese)
    )
    fun getFoodList(): List<FoodItem> {
        return foodlist
    }
}