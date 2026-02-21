package com.example.doan

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            switchFragment(item.itemId)
            true
        }

        if (savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.home
        }
    }

    private fun switchFragment(itemId: Int) {
        val fragment = when (itemId) {
            R.id.home -> com.example.doan.presentation.fragment.HomeFragment()
            R.id.cart -> com.example.doan.presentation.fragment.CartFragment()
            R.id.shop -> com.example.doan.presentation.fragment.ShopFragment()
            R.id.heart -> com.example.doan.presentation.fragment.FavouriteFragment()
            R.id.user -> com.example.doan.presentation.fragment.ProfileFragment()
            else -> return
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}