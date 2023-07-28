package com.example.yachin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // 2 seconds delay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Delay the transition to HomeFragment
        Handler(Looper.getMainLooper()).postDelayed({
            startHomeFragment()
        }, SPLASH_DELAY)
    }

    private fun startHomeFragment() {
        // Start HomeFragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.splash_container, HomeFragment())
        fragmentTransaction.addToBackStack(null) // If you want to add the fragment to back stack
        fragmentTransaction.commit()
    }
}
