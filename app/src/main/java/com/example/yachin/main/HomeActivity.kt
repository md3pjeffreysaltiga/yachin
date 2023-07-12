package com.example.yachin.main

//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.yachin.HomeFragment
//import com.example.yachin.PropertyAdapter
//import com.example.yachin.R
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.SupportMapFragment
//
//class HomeActivity : AppCompatActivity() {
//    private lateinit var mapFragment: SupportMapFragment
//    private lateinit var categoriesRecyclerView: RecyclerView
//
//    private val homeFragment = HomeFragment()
//    private val rentFragment = RentFragment()
//    private val accountFragment = AccountFragment()
//    private val settingsFragment = SettingsFragment()
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_home)
//
//        // Initialize views
//        mapFragment = supportFragmentManager.findFragmentById(R.id.flMap) as SupportMapFragment
//        categoriesRecyclerView = findViewById(R.id.recyclerView)
//
//        // Setup RecyclerView for categories
//        val layoutManager = LinearLayoutManager(this)
//        categoriesRecyclerView.layoutManager = layoutManager
//
////            // Find RecyclerView from the layout
////            recyclerView = findViewById(R.id.recyclerView)
////
////            // Create and set the PropertyAdapter
////            adapter = PropertyAdapter(propertyList, object : PropertyAdapter.OnItemClickListener {
////                override fun onItemClick(category: Properties) {
////                    // Handle item click event
////                }
////            })
////            recyclerView.adapter = adapter
////        }
//        // TODO: Implement the search functionality for the SearchView
//
//        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.home -> {
//                    replaceFragment(homeFragment)
//                    true
//                }
//                R.id.rent -> {
//                    replaceFragment(rentFragment)
//                    true
//                }
//                R.id.account -> {
//                    replaceFragment(accountFragment)
//                    true
//                }
//                R.id.settings -> {
//                    replaceFragment(settingsFragment)
//                    true
//                }
//                else -> false
//            }
//        }
//
//        // Set the home fragment as the default
//        replaceFragment(homeFragment)
//    }
//
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.flMap, fragment)
//            .commit()
//    }
//    }
//
//    // TODO: Implement necessary methods for Google Maps integration, e.g., onMapReady()
//
//    // TODO: Implement necessary methods for RecyclerView adapter and item click events
//}