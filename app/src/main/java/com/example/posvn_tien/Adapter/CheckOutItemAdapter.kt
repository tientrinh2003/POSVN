package com.example.posvn_tien.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posvn_tien.databinding.FoodCheckOutCartBinding
import com.example.posvn_tien.model.CartItem

class CheckOutItemAdapter(
    private val cartItems: MutableList<CartItem>,
) : RecyclerView.Adapter<CheckOutItemAdapter.CheckOutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckOutViewHolder {
        val binding = FoodCheckOutCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CheckOutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckOutViewHolder, position: Int) {
        val item = cartItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CheckOutViewHolder(private val binding: FoodCheckOutCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartItem) {
            binding.apply {
                cartItemName.text = item.name
                cartItemPrice.text = "${item.price}$"
                cartItemQuantity.text = "${item.quantity}"
                cartItemImage.setImageResource(item.imageResource)
            }
        }
    }
}

