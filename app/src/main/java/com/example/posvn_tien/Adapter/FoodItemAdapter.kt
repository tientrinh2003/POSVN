package com.example.posvn_tien.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.posvn_tien.data.CartDataProvider
import com.example.posvn_tien.databinding.FoodItemBinding
import com.example.posvn_tien.model.CartItem
import com.example.posvn_tien.model.FoodItem

class FoodItemAdapter(private var items: List<FoodItem>) : RecyclerView.Adapter<FoodItemAdapter.FoodlistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodlistViewHolder {
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodlistViewHolder(binding, parent.context) // Pass context here
    }

    override fun onBindViewHolder(holder: FoodlistViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FoodlistViewHolder(private val binding: FoodItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodItem) {
            binding.foodName1.text = item.name
            binding.supName1.text = "$${item.price}"
            binding.imageFood1.setImageResource(item.imageResource)

            binding.addButton.setOnClickListener {
                addToCart(item)
            }
        }

        private fun addToCart(item: FoodItem) {
            val cartItem = CartItem(item.name, item.price, 1, item.imageResource)
            CartDataProvider.cartList.add(cartItem)
            Toast.makeText(context, "You have ordered: ${item.name}", Toast.LENGTH_SHORT).show() // Use context here
        }
    }

    fun updateList(newList: List<FoodItem>) {
        items = newList
        notifyDataSetChanged()
    }
}