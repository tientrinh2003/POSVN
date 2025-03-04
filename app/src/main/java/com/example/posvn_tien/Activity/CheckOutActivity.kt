package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posvn_tien.Fragment.CongratsBottomSheet
import com.example.posvn_tien.R
import com.example.posvn_tien.adapter.CheckOutItemAdapter
import com.example.posvn_tien.databinding.ActivityCheckOutBinding
import com.example.posvn_tien.model.CartItem

class CheckOutActivity : AppCompatActivity() {
    private val binding: ActivityCheckOutBinding by lazy {
        ActivityCheckOutBinding.inflate(layoutInflater)
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
        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        binding.totalMoneyTV.text = "$totalPrice"

        // Initialize the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CheckOutItemAdapter(cartItems)
        binding.recyclerView.adapter = adapter

        // Set up the "Paid" button click listener
        binding.paidButton.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager, bottomSheetDialog.tag)
        }
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("destination", R.id.cartFragment)
            startActivity(intent)
        }
    }
}
