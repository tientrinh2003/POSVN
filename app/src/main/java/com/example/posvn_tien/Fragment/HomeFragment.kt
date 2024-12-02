package com.example.posvn_tien.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.posvn_tien.Adapter.FoodItemAdapter
import com.example.posvn_tien.R
import com.example.posvn_tien.databinding.FragmentHomeBinding
import com.example.posvn_tien.model.FoodItem

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Setup food list data
        val sampleData = listOf(
            FoodItem("Cheese burger", 8.24, R.drawable.hamcheese),
            FoodItem("Fries", 3.50, R.drawable.hamcheese)
        )

        // Setup RecyclerView with GridLayoutManager and Adapter
        val adapter = FoodItemAdapter(sampleData)
        binding.foodListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.foodListRecyclerView.adapter = adapter

        // Return the root view
        return binding.root
    }
}

