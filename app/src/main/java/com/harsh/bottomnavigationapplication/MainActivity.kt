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
    var binding: ActivityMainBinding? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        enableEdgeToEdge()
        navController = findNavController(R.id.host)

//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.bottomNav?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> navController?.navigate(R.id.firstFragment)
                R.id.contact -> navController?.navigate(R.id.secondFragment)
                R.id.login -> navController?.navigate(R.id.thirdFragment)
            }
            return@setOnItemSelectedListener true
        }
        navController?.addOnDestinationChangedListener { navController, destination, arguments ->
            when (destination.id) {
                R.id.firstFragment -> {
                    supportActionBar?.title = resources.getString(R.string.first_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.home)?.isChecked = true
                }

                R.id.secondFragment -> {
                    supportActionBar?.title = resources.getString(R.string.second_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.contact)?.isChecked = true
                }

                R.id.thirdFragment -> {
                    supportActionBar?.title = resources.getString(R.string.third_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.login)?.isChecked = true
                }
            }
        }
    }
}
