package com.example.yachin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import javax.security.auth.Subject

class SubjectAdapter(private val subjectList: List<Subject>) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subject_card, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.bind(subject)
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ownerTextView: TextView = itemView.findViewById(R.id.textViewOwner)
        private val rentPriceTextView: TextView = itemView.findViewById(R.id.textViewRentPrice)
        private val addressTextView: TextView = itemView.findViewById(R.id.textViewAddress)
        private val facebookTextView: TextView = itemView.findViewById(R.id.textViewFacebook)
        private val contactNumberTextView: TextView = itemView.findViewById(R.id.textViewContactNumber)

        fun bind(subject: Subject) {
            val resources = itemView.resources
                ownerTextView.text = itemView.context.getString(R.string.owner_label)
                rentPriceTextView.text = itemView.context.getString(R.string.rent_price_label)
                addressTextView.text = itemView.context.getString(R.string.address_label)
                facebookTextView.text = itemView.context.getString(R.string.facebook_label)
                contactNumberTextView.text = itemView.context.getString(R.string.contact_number_label)
            }
    }
}
