package com.example.yachin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.RentalPropertyViewHolder

class RentalPropertiesAdapter : RecyclerView.Adapter<RentalPropertiesAdapter.ViewHolder>() {

    private val rentalProperties = mutableListOf<RentalProperty>()

    fun setData(data: List<RentalProperty>) {
        rentalProperties.clear()
        rentalProperties.addAll(data)
        notifyDataSetChanged()
    }

    // ... (ViewHolder and other methods remain the same)

    // Update onBindViewHolder to bind data for each rental property
//    override fun onBindViewHolder(holder: RentalPropertyViewHolder, position: Int) {
//        val rentalProperty = rentalProperties[position]
//
//    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

//        val textView: TextView = itemView.findViewById(R.id.tv_text_sample)

        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(rentalProperty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    // ...
}
