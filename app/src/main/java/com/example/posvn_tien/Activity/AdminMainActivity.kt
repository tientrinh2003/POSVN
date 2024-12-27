package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.databinding.ActivityAdminMainBinding

class AdminMainActivity : AppCompatActivity() {
    private val binding: ActivityAdminMainBinding by lazy {
        ActivityAdminMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.cardViewAddMenu.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }
        binding.cardViewViewMenu.setOnClickListener {
            val intent = Intent(this, ViewMenuActivity::class.java)
            startActivity(intent)
        }
        binding.cardViewHistory.setOnClickListener {
            val intent = Intent(this, ViewOrderActivity::class.java)
            startActivity(intent)
        }
        binding.cardViewLogout.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}