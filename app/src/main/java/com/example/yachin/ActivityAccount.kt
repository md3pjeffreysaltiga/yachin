package com.example.yachin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yachin.databinding.ActivityAccountBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ActivityAccount : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            val price = binding.rentPrice.text.toString()
            val owner = binding.rentOwner.text.toString()
            val address = binding.rentAddress.text.toString()
            val fb = binding.rentFbAccount.text.toString()
            val cp = binding.rentContactNumber.text.toString()

            // Retrieve the email and password from SharedPreferences
            val email = UserSharedPreferences.getEmail(this)
            val password = UserSharedPreferences.getPassword(this)

            // Check if email and password are not null
            if (email != null && password != null) {
                // Authenticate with Firebase using email and password
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            // Save the data to Firestore using the authenticated user's email as the document ID
                            val firestore = FirebaseFirestore.getInstance()
                            val userDocument = firestore.collection("User").document(email)
                            val data = mapOf(
                                "owner" to owner,
                                "price" to price,
                                "address" to address,
                                "fb" to fb,
                                "cp" to cp
                            )

                            userDocument.set(data)
                                .addOnSuccessListener {
                                    Toast.makeText(this, "Data saved successfully.", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { exception ->
                                    Toast.makeText(this, "Failed to save data: ${exception.message}", Toast.LENGTH_SHORT).show()
                                }
                        } else {
                            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Email or password not found.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



