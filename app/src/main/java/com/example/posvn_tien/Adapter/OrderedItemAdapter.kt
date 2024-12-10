package com.example.posvn_tien.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posvn_tien.databinding.OrderedItemBinding
import com.example.posvn_tien.model.OrderedItem

class OrderedItemAdapter(private var items: List<OrderedItem>) : RecyclerView.Adapter<OrderedItemAdapter.OrderedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderedItemViewHolder {
        // Correctly initialize the binding with LayoutInflater and parent
        val binding = OrderedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderedItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        // Return the number of items
        return items.size
    }

    inner class OrderedItemViewHolder(private val binding: OrderedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrderedItem, position: Int) {
            binding.apply {
                orderCode.text = item.code
                cartItemPrice.text = "${item.price}$"
                cartItemImage.setImageResource(item.imageResource)
                buyAgain.setOnClickListener{
                    buyAgain(position)
                }

                moreDetailTV.setOnClickListener{
                    showOrderedDetails(position)
                }
            }
        }
    }
    private fun buyAgain(position: Int) {

    }

    private fun showOrderedDetails(position: Int) {

    }
}
