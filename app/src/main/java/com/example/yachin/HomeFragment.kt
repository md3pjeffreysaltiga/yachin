package com.example.yachin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.NestedScrollView
import androidx.navigation.fragment.findNavController
import com.example.yachin.databinding.FragmentHomeBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class HomeFragment() : Fragment(),  OnMapReadyCallback {
    public var HomeFragment: HomeFragment = this


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.flMap) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Set up the map style (optional)
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style))

        // Add markers
        val quezonCityLatLng = LatLng(14.6760, 121.0437) // Quezon City
        val makatiCityLatLng = LatLng(14.5547, 121.0244) // Makati City

        googleMap.addMarker(MarkerOptions().position(quezonCityLatLng).title("Quezon City"))
        googleMap.addMarker(MarkerOptions().position(makatiCityLatLng).title("Makati City"))

        // Move camera to a specific location (optional)
        val cameraPosition = CameraPosition.builder().target(quezonCityLatLng).zoom(10f).build()
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))


    }

    fun saveUserData(view: View) {
        val username = etUsername.text.toString()
        val email = etEmail.text.toString()
        UserSharedPreferences.saveUserRegistration(requireContext(), username, email)
    }

}