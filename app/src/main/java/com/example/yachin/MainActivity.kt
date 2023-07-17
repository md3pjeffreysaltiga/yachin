package com.example.yachin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yachin.main.Properties


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val propertyList = listOf(
            Properties(R.drawable.apartment, "Apartment for Rent"),
            Properties(R.drawable.condo, "Condo for Rent"),
            Properties(R.drawable.bedspace, "Bed-spacer"),
            Properties(R.drawable.studio, "Room for Rent"),)

    }

}
