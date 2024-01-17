package com.example.gardeningjournalapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.gardeningjournalapp.databinding.ActivityMainBinding
import com.example.gardeningjournalapp.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this,navHostFragment.navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
        return NavigationUI.navigateUp(navHostFragment.navController,null)
    }
}