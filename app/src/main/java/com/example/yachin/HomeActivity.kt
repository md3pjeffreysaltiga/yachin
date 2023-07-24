package com.example.yachin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class HomeActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.flMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

     override fun onMapReady(googleMap: GoogleMap) {
        // Set up the map style (optional)
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))

        // Add markers
        val quezonCityLatLng = LatLng(14.6760, 121.0437) // Quezon City
        val makatiCityLatLng = LatLng(14.5547, 121.0244) // Makati City

        googleMap.addMarker(MarkerOptions().position(quezonCityLatLng).title("Quezon City"))
        googleMap.addMarker(MarkerOptions().position(makatiCityLatLng).title("Makati City"))

        // Move camera to a specific location (optional)
        val cameraPosition = CameraPosition.builder().target(quezonCityLatLng).zoom(10f).build()
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }


}

//    private fun navigateToAllRentalPropertiesFragment(category: String) {
//        val fragment = AllRentalPropertiesFragment.newInstance(category)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
