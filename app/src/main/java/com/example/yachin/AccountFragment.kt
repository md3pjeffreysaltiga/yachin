package com.example.yachin

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yachin.databinding.FragmentAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AccountFragment : Fragment()  {
    public var HomeFragment: AccountFragment = this

    private var cloudDB = FirebaseFirestore.getInstance()
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var rentItemRecyclerView: RecyclerView

    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_LOGGED_IN = "logged_in"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Check if user is already logged in
        val isLoggedIn = sharedPreferences.getBoolean(KEY_LOGGED_IN, false)
        if (isLoggedIn) {
            binding.layoutAccount.visibility = View.VISIBLE
            binding.layoutRegister.visibility = View.GONE
            // Load saved email and password
//            val savedEmail = sharedPreferences.getString(KEY_EMAIL, "")
//            val savedPassword = sharedPreferences.getString(KEY_PASSWORD, "")
//            binding.idincluderegister.etEmail.setText(savedEmail)
//            binding.idincluderegister.etPassword.setText(savedPassword)
        } else {
            binding.layoutAccount.visibility = View.GONE
            binding.layoutRegister.visibility = View.VISIBLE
        }

        binding.idincluderegister.registerButton.setOnClickListener {
 //           firebaseAuth.signInWithEmailAndPassword( binding.idincluderegister.etEmail.text.toString(),
            firebaseAuth.createUserWithEmailAndPassword( binding.idincluderegister.etEmail.text.toString(),
                binding.idincluderegister.etPassword.text.toString()  ).addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    binding.layoutAccount.visibility=View.VISIBLE
                    binding.layoutRegister.visibility=View.GONE
                    Log.e("Riz","Login")

                    // Initialize SharedPreferences
                    val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()

                    // Save the registered email and password in SharedPreferences
                    val email = binding.idincluderegister.etEmail.text.toString()
                    val password = binding.idincluderegister.etPassword.text.toString()
                    editor.putString(KEY_EMAIL, email)
                    editor.putString(KEY_PASSWORD, password)
                    editor.putBoolean(KEY_LOGGED_IN, true)
                    editor.apply()
                } else {
                    binding.layoutAccount.visibility=View.GONE
                    binding.layoutRegister.visibility=View.VISIBLE

                }
            }
        }



        binding.idincludeaccount.submitBtn.setOnClickListener {
            val owner = binding.idincludeaccount.rentOwner.text.toString()
            val price = binding.idincludeaccount.rentPrice.text.toString()
            val address = binding.idincludeaccount.rentAddress.text.toString()
            val fb = binding.idincludeaccount.rentFbAccount.text.toString()
            val cp = binding.idincludeaccount.rentContactNumber.text.toString()

            saveToFireStore(owner, price, address, fb, cp)
            Log.e("Jeff", "Data submission initiated.")
        }

    }

    private fun saveToFireStore(owner: String, price : String, address: String, fb: String, cp: String) {
        FirebaseFirestore.setLoggingEnabled(true)
        val sampleUser: MutableMap<String, Any> = HashMap()
        sampleUser["owner"]      = owner
        sampleUser["price"]      = price
        sampleUser["address"]    = address
        sampleUser["fb"]         = fb
        sampleUser["cp"]         = cp

        cloudDB.collection("User")
            .add(sampleUser)
            .addOnSuccessListener {
                Log.e("FIRE", "Success")
                binding.idincludeaccount.rentOwner.setText("")
                binding.idincludeaccount.rentPrice.setText("")
                binding.idincludeaccount.rentAddress.setText("")
                binding.idincludeaccount.rentFbAccount.setText("")
                binding.idincludeaccount.rentContactNumber.setText("")
                Toast.makeText(requireContext(), "Data submitted.", Toast.LENGTH_LONG).show()
                apiCall()
            }
            .addOnFailureListener { Log.e("FIRE", "Failed > " + it.toString()) }

    }

    fun apiCall() {
        cloudDB.collection("User")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result?.let { snap ->
                        snap.forEach { docu ->
                            var docIdValue = ""
                            var owner = ""
                            var price = ""
                            var address = ""
                            var fb = ""
                            var cp = ""
                            docIdValue = docu.id.toString()
                            docu.data.forEach {
                                when (it.key.toString()) {
                                    "owner" -> { owner = it.value.toString() }
                                    "price" -> { price = it.value.toString() }
                                    "address" -> { address = it.value.toString() }
                                    "fb" -> { fb = it.value.toString() }
                                    "cp" -> { cp = it.value.toString() }
                                }

                            }
//                            val newUser = CloudUsers(docIdValue, nameValue, roleValue, urlValue)
//                            usersList.add(newUser)
                            Log.e("Riz", owner + "\n" + price + "\n" + address + "\n" + cp + "\n" + fb)
                        }
//                        usersLive.postValue(usersList)
//                        Log.e("CLOUD", "usersList > ${usersList.toString()}")
                    }
                }
            }
    }
}