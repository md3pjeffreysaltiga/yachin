package com.example.yachin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.Activity.Properties

class PropertyAdapter(private val propertyList: List<Properties>, private val listener: OnItemClickListener) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(category: Properties)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rent, parent, false)
        return PropertyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = propertyList[position]
        holder.bind(property)
    }

    override fun getItemCount(): Int {
        return propertyList.size
    }

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val propertyTextView: TextView = itemView.findViewById(R.id.rv_rent_list)

        fun bind(category: Properties) {
            propertyTextView.text = category.name as CharSequence?
            itemView.setOnClickListener {
                listener.onItemClick(category)
            }
        }
    }

}
