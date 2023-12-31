package com.example.yachin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.databinding.FragmentRentBinding
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

class RentFragment : Fragment() {

    private var cloudDB = FirebaseFirestore.getInstance()
    private var _binding: FragmentRentBinding? = null
    private val binding get() = _binding!!
    private val rentList: MutableList<RentItem> = mutableListOf()
    private lateinit var rentAdapter: RentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchRentData()
    }

    private fun setupRecyclerView() {
        rentAdapter = RentAdapter(rentList)
        binding.rvRentList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rentAdapter
        }
    }

    private fun fetchRentData() {
        cloudDB.collection("User")
            .get()
            .addOnSuccessListener { documents ->
                rentList.clear()
                for (document in documents) {
                    val owner = document.getString("owner") ?: ""
                    val price = document.getString("price") ?: ""
                    val address = document.getString("address") ?: ""
                    val fb = document.getString("fb") ?: ""
                    val cp = document.getString("cp") ?: ""
                    rentList.add(RentItem(owner, price, address, fb, cp))
                }
                rentAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.e("RentFragment", "Error fetching rent data: ${exception.message}")
            }
    }

}
