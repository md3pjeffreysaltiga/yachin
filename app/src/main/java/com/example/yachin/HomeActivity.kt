package com.example.yachin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.yachin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    //class HomeActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.navhost_fragment1)
//            appBarConfiguration = AppBarConfiguration(navController.graph)
//            setupActionBarWithNavController(navController, appBarConfiguration)
        setupWithNavController(binding.bottomNavMain, navController)

    }
}
