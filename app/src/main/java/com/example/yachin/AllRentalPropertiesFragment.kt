package com.example.yachin

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class AllRentalPropertiesFragment : Fragment() {
//
//    companion object {
//        private const val ARG_CATEGORY = "category"
//
//        fun newInstance(category: String): AllRentalPropertiesFragment {
//            val fragment = AllRentalPropertiesFragment()
//            val args = Bundle()
//            args.putString(ARG_CATEGORY, category)
//            fragment.arguments = args
//            return fragment
//        }
//    }
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var rentalPropertiesAdapter: RentalPropertiesAdapter
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_all_rental_properties, container, false)
//
//        recyclerView = view.findViewById(R.id.recyclerView)
//        // Initialize and set up the rentalPropertiesAdapter with the data for the specific category
//        rentalPropertiesAdapter = RentalPropertiesAdapter(getRentalPropertiesForCategory())
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = rentalPropertiesAdapter
//
//        return view
//    }
//
//    // Fetch the data for the specific category
//    private fun getRentalPropertiesForCategory(): List<RentalProperty> {
//        val category = arguments?.getString(ARG_CATEGORY)
//        // Implement your logic here to fetch the rental property data for the given category
//        // For example, you could use a database or a data source to retrieve the data
//        // and return it as a list of RentalProperty objects
//        // Replace the dummy data below with your actual data retrieval logic
//        return listOf(
//            RentalProperty("Property 1", category),
//            RentalProperty("Property 2", category),
//            // Add more rental properties for the specific category
//        )
//    }
//}
