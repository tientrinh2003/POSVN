package com.example.posvn_tien.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.databinding.ActivityViewOrderBinding

class ViewOrderActivity : AppCompatActivity() {
    private val binding: ActivityViewOrderBinding by lazy {
        ActivityViewOrderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}