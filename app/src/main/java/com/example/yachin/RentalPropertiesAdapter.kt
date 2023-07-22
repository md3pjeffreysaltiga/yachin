package com.example.yachin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RentalPropertiesAdapter : RecyclerView.Adapter<RentalPropertiesAdapter.RentalPropertyViewHolder>() {

    private val rentalProperties = mutableListOf<RentalProperty>()

    fun setData(data: List<RentalProperty>) {
        rentalProperties.clear()
        rentalProperties.addAll(data)
        notifyDataSetChanged()
    }

    // ... (ViewHolder and other methods remain the same)

    // Update onBindViewHolder to bind data for each rental property
    override fun onBindViewHolder(holder: RentalPropertyViewHolder, position: Int) {
        val rentalProperty = rentalProperties[position]
        holder.bind(rentalProperty)
    }

    // ...
}
