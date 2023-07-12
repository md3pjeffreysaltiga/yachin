package com.example.yachin

//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.widget.SearchView
//import androidx.recyclerview.widget.RecyclerView
//
//class SearchFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Set up any additional logic or view initialization here
//        // For example, you can find views and set click listeners
//        val searchView = view.findViewById<SearchView>(R.id.search_home)
//        // Add click listener to searchView and implement search functionality
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                // Perform search logic here
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                // Perform real-time filtering logic here
//                return true
//            }
//        })
//
//        // Set up RecyclerView and its adapter, and populate data
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        val adapter = PropertyAdapter()
//        recyclerView.adapter = adapter
//        // Populate data into the adapter
//        // adapter.submitList(yourDataList)
//    }
//
//}
//
