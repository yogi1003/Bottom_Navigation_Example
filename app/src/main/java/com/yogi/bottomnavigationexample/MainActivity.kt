package com.yogi.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yogi.bottomnavigationexample.fragment.HomeFragment
import com.yogi.bottomnavigationexample.fragment.NotificationFragment
import com.yogi.bottomnavigationexample.fragment.SettingsFragment

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()
        val notificationFragment = NotificationFragment()

        makeCurrentFragment (homeFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
                R.id.menu_notification -> makeCurrentFragment(notificationFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}