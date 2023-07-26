package com.example.yachin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.databinding.FragmentRentBinding
import com.google.firebase.database.*

class RentFragment() : Fragment()  {
    public var HomeFragment: RentFragment = this


    private var _binding: FragmentRentBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbref : DatabaseReference
    private lateinit var rentalArrayList : ArrayList<User>
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rentalArrayList = arrayListOf()
        adapter = RecyclerViewAdapter(rentalArrayList)
        binding.rvRentList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRentList.setHasFixedSize(true)
        binding.rvRentList.adapter = adapter

        dbref = FirebaseDatabase.getInstance().getReference("User")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    rentalArrayList.clear()
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        user?.let {
                            rentalArrayList.add(it)
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show()
            }
        })
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        // Clear the binding reference to avoid memory leaks
//        binding = null
//    }





}