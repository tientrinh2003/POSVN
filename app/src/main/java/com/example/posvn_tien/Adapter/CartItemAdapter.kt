package com.example.posvn_tien.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posvn_tien.databinding.FoodCartBinding
import com.example.posvn_tien.model.CartItem

class CartItemAdapter(
    private val cartItems: MutableList<CartItem>,
    private val onItemRemoved: (Double) -> Unit // Callback to update total price
) : RecyclerView.Adapter<CartItemAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = FoodCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class CartViewHolder(private val binding: FoodCartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartItem, position: Int) {
            binding.apply {
                cartItemName.text = item.name
                cartItemPrice.text = "${item.price}$"
                cartItemQuantity.text = "${item.quantity}"
                cartItemImage.setImageResource(item.imageResource)

                increaseButton.setOnClickListener {
                    increaseQuantity(position)
                }

                decreaseButton.setOnClickListener {
                    decreaseQuantity(position)
                }

                deleteButton.setOnClickListener {
                    deleteItem(position)
                }
            }
        }
    }

    // Update the total price and notify the fragment/activity
    private fun updateTotalPrice() {
        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        onItemRemoved(totalPrice) // Notify the fragment/activity with the updated price
    }

    // Delete an item from the cart
    private fun deleteItem(position: Int) {
        cartItems.removeAt(position)
        notifyItemRemoved(position) // Notify the adapter about item removal
        notifyItemRangeChanged(position, cartItems.size) // Adjust remaining items
        updateTotalPrice() // Update the total price after deletion
    }

    // Increase the quantity of an item
    private fun increaseQuantity(position: Int) {
        if (cartItems[position].quantity < 10) { // Maximum quantity check
            cartItems[position].quantity++
            notifyItemChanged(position) // Notify the adapter about the change
        }
        updateTotalPrice() // Update the total price after quantity change
    }

    // Decrease the quantity of an item
    private fun decreaseQuantity(position: Int) {
        if (cartItems[position].quantity > 1) { // Minimum quantity check
            cartItems[position].quantity--
            notifyItemChanged(position) // Notify the adapter about the change
        }
        updateTotalPrice() // Update the total price after quantity change
    }
}
