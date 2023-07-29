package com.example.yachin

import android.content.Intent
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
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }
}
