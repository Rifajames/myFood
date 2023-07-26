package com.example.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myfood.databinding.ActivityHomeBinding
import com.example.myfood.fragment.HomeFragment
import com.example.myfood.fragment.ProfileFragment
import com.example.myfood.fragment.ShopFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bottomNav = binding.bottomNavigation
        val homeFragment = HomeFragment()
        val shopFragment = ShopFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome -> setCurrentFragment(homeFragment)
                R.id.navShoppingCart -> setCurrentFragment(shopFragment)
                R.id.navProfile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameNavigation, fragment)
            commit()
        }
    }
}