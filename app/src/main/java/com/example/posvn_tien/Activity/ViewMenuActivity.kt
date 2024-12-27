package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posvn_tien.Adapter.MenuItemAdapter
import com.example.posvn_tien.R
import com.example.posvn_tien.databinding.ActivityViewMenuBinding
import com.example.posvn_tien.model.CartItem

class ViewMenuActivity : AppCompatActivity() {
    private val binding: ActivityViewMenuBinding by lazy {
        ActivityViewMenuBinding.inflate(layoutInflater)
    }

    private val cartItems = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Add sample items
        cartItems.apply {
            add(CartItem("Burger", 5.99, 2, R.drawable.hamcheese))
            add(CartItem("Fries", 2.99, 1, R.drawable.hamcheese))
            add(CartItem("Soda", 1.99, 3, R.drawable.hamcheese))
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MenuItemAdapter(cartItems)
        {
            // Recalculate total price when an item is removed
            updateTotalPrice()
        }
        binding.recyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            val intent = Intent(this, AdminMainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun updateTotalPrice() {
        val total = cartItems.sumOf { it.price * it.quantity }
    }
}