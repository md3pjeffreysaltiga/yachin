package com.example.yachin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yachin.databinding.FragmentAccountBinding
import com.google.firebase.auth.FirebaseAuth

class AccountFragment() : Fragment()  {
    public var HomeFragment: AccountFragment = this

    private var firebaseAuth = FirebaseAuth.getInstance()
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idincluderegister.registerButton.setOnClickListener {
 //           firebaseAuth.signInWithEmailAndPassword( binding.idincluderegister.etEmail.text.toString(),
            firebaseAuth.createUserWithEmailAndPassword( binding.idincluderegister.etEmail.text.toString(),
                binding.idincluderegister.etPassword.text.toString()  ).addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    binding.layoutAccount.visibility=View.VISIBLE
                    binding.layoutRegister.visibility=View.GONE
                    Log.e("Riz","Login")
                } else {
                    binding.layoutAccount.visibility=View.GONE
                    binding.layoutRegister.visibility=View.VISIBLE

                }
            }
        }

    }


}