package com.example.posvn_tien.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posvn_tien.databinding.FoodItemBinding
import com.example.posvn_tien.model.FoodItem

class FoodItemAdapter(private var items: List<FoodItem>) : RecyclerView.Adapter<FoodItemAdapter.FoodlistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodlistViewHolder {
        // Correctly initialize the binding with LayoutInflater and parent
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodlistViewHolder, position: Int) {
        // Get the FoodItem at the current position
        val item = items[position]

        // Pass the item's properties to the bind method
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        // Return the number of items
        return items.size
    }

    class FoodlistViewHolder(private val binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodItem) {
            binding.foodName1.text = item.name             // Set food name
            binding.supName1.text = "$${item.price}"       // Set price with formatting
            binding.imageFood1.setImageResource(item.imageResource) // Set image

            binding.addButton.setOnClickListener {

            }
        }
    }

    // Method to update the list dynamically

    fun updateList(newList: List<FoodItem>) {
        items = newList // Update the list
        notifyDataSetChanged() // Notify the adapter to refresh the UI
    }
}
