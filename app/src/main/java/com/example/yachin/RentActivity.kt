package com.example.yachin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.example.yachin.databinding.ActivityRentBinding

class RentActivity : AppCompatActivity() {

    private var cloudDB = FirebaseFirestore.getInstance()
    private lateinit var binding: ActivityRentBinding
    private val rentList: MutableList<RentItem> = mutableListOf()
    private lateinit var rentAdapter: RentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchRentData()
    }

    private fun setupRecyclerView() {
        rentAdapter = RentAdapter(rentList)
        binding.rvRentList.apply {
            layoutManager = LinearLayoutManager(this@RentActivity)
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
                Log.e("RentActivity", "Error fetching rent data: ${exception.message}")
            }
    }
}
