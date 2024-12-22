package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.databinding.ActivityCheckOutBinding
import com.example.posvn_tien.qrSheet

class CheckOutActivity : AppCompatActivity() {
    private val binding: ActivityCheckOutBinding by lazy {
        ActivityCheckOutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.paidButton.setOnClickListener{
            val intent = Intent(this, qrSheet::class.java)
            startActivity(intent)
        }
    }
}