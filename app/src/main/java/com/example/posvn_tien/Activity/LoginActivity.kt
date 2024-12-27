package com.example.posvn_tien.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.posvn_tien.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.loginButton.setOnClickListener{
            if (
                binding.editTextTextEmailAddress.text.toString() == "admin" && binding.editTextTextPassword.text.toString() == "admin"
                || binding.radioButtonAdmin.isChecked
                ) {
            val intent = Intent(this, AdminMainActivity::class.java)
            startActivity(intent)
            }
            else if (
                binding.editTextTextEmailAddress.text.toString() == "customer" && binding.editTextTextPassword.text.toString() == "customer"
                || binding.radioButtonCustomer.isChecked
            ) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                binding.editTextTextEmailAddress.error = "Invalid username or password"
                binding.editTextTextPassword.error = "Invalid username or password"
            }
        }
        binding.donthaveaccountBT.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}