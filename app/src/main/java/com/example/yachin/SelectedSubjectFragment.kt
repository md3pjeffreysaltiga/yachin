package com.example.yachin

//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.yachin.databinding.FragmentSecondBinding
//import javax.security.auth.Subject
//
//class SelectedSubjectFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: SubjectAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_selected_subject, container, false)
//        recyclerView = view.findViewById(R.id.rv_rent_list)
//
//        // Assuming you have a list that contains all instances of the selected subject
//        val subjectList: List<Subject> = getSelectedSubjectList()
//
//        adapter = SubjectAdapter(subjectList)
//        recyclerView.adapter = adapter
//
//        // Set any desired layout manager, e.g., LinearLayoutManager
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        return view
//    }
//
//    private fun getSelectedSubjectList(): List<Subject> {
//        // Here, you should return the list of instances of the selected subject
//        // For example, if you have a RoomForRentManager to manage RoomForRent instances, you can do:
//        // return RoomForRentManager.roomList
//
//        // Replace the following with your actual list of instances for the selected subject
//        return listOf(
//            Subject("John Doe", 500.0, "123 Main St", "john.doe", "+1234567890"),
//            Subject("Jane Smith", 600.0, "456 Park Ave", "jane.smith", "+9876543210")
//        )
//    }
//}
