package com.example.yachin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.databinding.ItemRentBinding

class RentAdapter(private val rentList: List<RentItem>) : RecyclerView.Adapter<RentAdapter.RentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentViewHolder {
        val binding = ItemRentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RentViewHolder, position: Int) {
        val rentItem = rentList[position]
        holder.bind(rentItem)
    }

    override fun getItemCount(): Int = rentList.size

    inner class RentViewHolder(private val binding: ItemRentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(rentItem: RentItem) {
            binding.apply {
                rentalOwner.text = rentItem.owner
                rentalPrice.text = rentItem.price
                rentalAddress.text = rentItem.address
                rentalFb.text = rentItem.fb
                rentalContact.text = rentItem.cp
            }
        }
    }
}
