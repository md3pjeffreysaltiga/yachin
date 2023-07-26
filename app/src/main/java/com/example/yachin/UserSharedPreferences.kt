package com.example.yachin

import android.content.Context
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

object UserSharedPreferences {
    private const val PREFS_NAME = "user_prefs"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"
    private const val USERS_COLLECTION = "users"

    fun saveUserRegistration(context: Context, email: String, password: String) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASSWORD, password)
        editor.apply()

        // Save the user data in Firestore
        val firestore = FirebaseFirestore.getInstance()
        val userDocument = firestore.collection(USERS_COLLECTION).document(email)
        userDocument.set(mapOf(KEY_EMAIL to email, KEY_PASSWORD to password))
    }

    fun getEmail(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_EMAIL, null)
    }

    fun getPassword(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_PASSWORD, null)
    }

    fun fetchUserDataFromFirestore(email: String, onUserDataFetched: (String?, String?) -> Unit) {
        val firestore = FirebaseFirestore.getInstance()
        val userDocument = firestore.collection(USERS_COLLECTION).document(email)
        userDocument.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val userData = documentSnapshot.data
                    val userEmail = userData?.get(KEY_EMAIL) as? String
                    val userPassword = userData?.get(KEY_PASSWORD) as? String
                    onUserDataFetched(userEmail, userPassword)
                } else {
                    onUserDataFetched(null, null)
                }
            }
            .addOnFailureListener {
                onUserDataFetched(null, null)
            }
    }
}
