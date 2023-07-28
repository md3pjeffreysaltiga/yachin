package com.example.yachin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val rentalList : ArrayList<RentItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rent, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return rentalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = rentalList[position]

        holder.price.text = currentItem.price
        holder.owner.text = currentItem.owner
        holder.address.text = currentItem.address
        holder.cp.text = currentItem.cp
        holder.fb.text = currentItem.fb

    }

    class MyViewHolder(ItemView : android.view.View) : RecyclerView.ViewHolder(ItemView) {

        val price = itemView.findViewById<TextView>(R.id.rental_price)
        val owner = itemView.findViewById<TextView>(R.id.rental_owner)
        val address = itemView.findViewById<TextView>(R.id.rental_address)
        val cp = itemView.findViewById<TextView>(R.id.rental_contact)
        val fb = itemView.findViewById<TextView>(R.id.rental_fb)

    }


}
