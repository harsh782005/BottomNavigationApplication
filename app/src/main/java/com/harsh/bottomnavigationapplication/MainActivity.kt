package com.harsh.bottomnavigationapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.harsh.bottomnavigationapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  var binding : ActivityMainBinding ?= null
    var navController:NavController ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.bottomNav?.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home ->  navController?.navigate(R.id.FirstFragment)
                R.id.details ->  navController?.navigate(R.id.SecondFragment)
                R.id.login ->  navController?.navigate(R.id.ThirdFragment)
            }
            return@setOnItemSelectedListener true
        }
      navController = findNavController(R.id.host)
    }
    }
