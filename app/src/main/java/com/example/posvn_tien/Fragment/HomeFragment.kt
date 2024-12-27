package com.example.posvn_tien.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.posvn_tien.Adapter.FoodItemAdapter
import com.example.posvn_tien.data.FoodListDataProvider
import com.example.posvn_tien.databinding.FragmentHomeBinding
import com.example.posvn_tien.model.FoodItem


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: FoodItemAdapter
    private val getFoodList = FoodListDataProvider.getFoodList()
    private val foodList = mutableListOf<FoodItem>() // Master list of food items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Ensure the SearchView is not iconified by default
        binding.searchView.setIconifiedByDefault(false)
        // Setup food list data
        if (foodList.isEmpty())
            foodList.addAll(getFoodList)

        // Setup RecyclerView with GridLayoutManager and Adapter
        adapter = FoodItemAdapter(foodList)
        binding.foodListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.foodListRecyclerView.adapter = adapter

        // Set up SearchView
        setUpSearchView()

        // Return the root view
        return binding.root
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query) // Filter items when the query is submitted
                return true // Indicating that we handled the event
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText) // Filter items as the text changes
                return true // Indicating that we handled the event
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        if (query.isNullOrEmpty()) {
            adapter.updateList(foodList) // Show full list if the query is empty
        } else {
            val filteredList = foodList.filter {
                it.name.contains(query, ignoreCase = true) // Case-insensitive filtering
            }
            adapter.updateList(filteredList) // Update the adapter with the filtered list
        }
    }
}
