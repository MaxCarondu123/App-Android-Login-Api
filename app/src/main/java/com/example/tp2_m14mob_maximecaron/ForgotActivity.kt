package com.example.tp2_m14mob_maximecaron

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tp2_m14mob_maximecaron.databinding.ActivityForgotBinding
import com.example.tp2_m14mob_maximecaron.databinding.ActivityLoginBinding

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("UserName", Context.MODE_PRIVATE)
        val edit = sharedPref.edit()

        binding.btnReset.setOnClickListener{
            val user = sharedPref.getString(binding.edtUsernameForgot.text.toString(), "")

            if (user.toString().isNotEmpty()) {
                edit.remove(binding.edtUsernameForgot.text.toString())
                edit.apply()
                edit.putString(binding.edtUsernameForgot.text.toString(), binding.edtPasswordForgot.text.toString())
                edit.commit()

                Toast.makeText(this, "Password Reset Succes", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }else if(binding.edtUsernameForgot.text.toString() == "" && binding.edtPasswordForgot.text.toString() == ""){
                Toast.makeText(this, "Username Or Password is Empty", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReturn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}