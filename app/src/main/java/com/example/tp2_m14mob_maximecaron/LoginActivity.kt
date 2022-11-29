package com.example.tp2_m14mob_maximecaron

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp2_m14mob_maximecaron.databinding.ActivityLoginBinding
import com.example.tp2_m14mob_maximecaron.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("UserName", Context.MODE_PRIVATE)

        binding.btnConnect.setOnClickListener {
            val user = sharedPref.getString(binding.edtUsername.text.toString(), "")

            if (user.toString().isNotEmpty()) {

                if (binding.edtPassword.text.toString() == user){
                    Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java).also {
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show()
                }

            } else if (binding.edtUsername.text.toString() == "" && binding.edtPassword.text.toString() == "") {
                Toast.makeText(this, "Username Or Password is Empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnForgotPass.setOnClickListener {
            val intent = Intent(this, ForgotActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}