package com.example.tp2_m14mob_maximecaron

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp2_m14mob_maximecaron.databinding.ActivityMainBinding
import com.example.tp2_m14mob_maximecaron.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("UserName", Context.MODE_PRIVATE)
        var edit = sharedPref.edit()

        binding.btnCreateAccount.setOnClickListener {
            if(binding.edtUsernameReg.text.toString() != "" && binding.edtPasswordReg.text.toString() != ""){
                Toast.makeText(this, "Register Completed", Toast.LENGTH_SHORT).show()
                edit.putString(binding.edtUsernameReg.text.toString(), binding.edtPasswordReg.text.toString())
                edit.commit()
                val intent = Intent(this, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }else{
                Toast.makeText(this, "Username Or Password is Empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReturn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}