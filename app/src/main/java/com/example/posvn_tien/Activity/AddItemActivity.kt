package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {
    private val binding: ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageButtonTurnBack.setOnClickListener {
            val intent = Intent(this, AdminMainActivity::class.java)
            startActivity(intent)
        }
        binding.textViewChooseImage.setOnClickListener {
            // Implement image selection logic here
            pickimage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        }
        val pickimage = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
                uri -> if (uri != null) {
            binding.imageView3.setImageURI(uri)
        }
    }
}