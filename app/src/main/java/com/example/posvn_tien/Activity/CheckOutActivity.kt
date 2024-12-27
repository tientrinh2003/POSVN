package com.example.posvn_tien.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.Fragment.CongratsBottomSheet
import com.example.posvn_tien.databinding.ActivityCheckOutBinding

class CheckOutActivity : AppCompatActivity() {
    private val binding: ActivityCheckOutBinding by lazy {
        ActivityCheckOutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.paidButton.setOnClickListener{
            val BottomSheetDialog = CongratsBottomSheet()
            BottomSheetDialog.show(supportFragmentManager, BottomSheetDialog.tag)
        }
    }
}