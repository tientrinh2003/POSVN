package com.example.posvn_tien.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posvn_tien.Activity.CheckOutActivity
import com.example.posvn_tien.Adapter.CartItemAdapter
import com.example.posvn_tien.data.CartDataProvider
import com.example.posvn_tien.databinding.FragmentCartBinding
import com.example.posvn_tien.model.CartItem

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val cartItems = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize binding
        binding = FragmentCartBinding.inflate(inflater, container, false)

        // Sample data
        cartItems.addAll(CartDataProvider.cartList)

        // Set up RecyclerView with LinearLayoutManager and Adapter
        val cartAdapter = CartItemAdapter(cartItems) {
            // Recalculate total price when an item is removed
            updateTotalPrice()
        }
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = cartAdapter

        // Calculate total price
        updateTotalPrice()

<<<<<<< HEAD
=======
        // Checkout button
        binding.checkoutButton.setOnClickListener {
            if (cartItems.isNotEmpty()) {
                // Use requireContext() as the context for the Intent
                val intent = Intent(requireContext(), CheckOutActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Cart is empty!", Toast.LENGTH_SHORT).show()
            }
        }


>>>>>>> a5bb51bc070dcf37a05a199f7337753794ae3e74
        // Return the root view
        return binding.root
    }

    private fun updateTotalPrice() {
        val total = cartItems.sumOf { it.price * it.quantity }
        binding.totalPrice.text = "$${String.format("%.2f", total)}"
    }
}