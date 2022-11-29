package com.example.tp2_m14mob_maximecaron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp2_m14mob_maximecaron.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val endPoint = "https://api2.binance.com/api/v3/ticker/24hr"

        val typeToken = object: TypeToken<List<Todo>>(){}.type

        lifecycleScope.launch(Dispatchers.Default){
            val strTodo = URL(endPoint).readText()
            println(strTodo)

            val todos = Gson().fromJson<List<Todo>>(strTodo, typeToken)
            println(todos)

            this@MainActivity.runOnUiThread {

                //RV
                val adapter = RvAdapter(todos)
                binding.rvTodo.adapter = adapter
                binding.rvTodo.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        binding.btnDeco.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}