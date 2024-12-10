package com.example.posvn_tien.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posvn_tien.Adapter.OrderedItemAdapter
import com.example.posvn_tien.R
import com.example.posvn_tien.databinding.FragmentHistoryBinding
import com.example.posvn_tien.model.OrderedItem

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val orderedItems = mutableListOf<OrderedItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize binding
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        // Sample data
        orderedItems.apply {
            add(OrderedItem("HFKADF6", 8.24, R.drawable.hamcheese))
            add(OrderedItem("DFGSER2", 3.50, R.drawable.hamcheese))
        }

        binding.orderedRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.orderedRecycleView.adapter = OrderedItemAdapter(orderedItems)

        // Return the root view
        return binding.root
    }
}