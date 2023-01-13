package com.example.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.mobile.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

const val TAG_AUTH = "FirebaseAuth"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        binding.apply {
//            susuButton.setOnClickListener {
//                signInUser("susu@gmail.com", "888888", "susu")
//            }
//            hsienhsienButton.setOnClickListener {
//                signInUser("hsienhsien@gmail.com", "888888", "hsienhsien")
        }
    }

    private fun signInUser(email: String, password: String, who: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    changeTextView("SignIn success, UID: ${it.result.user?.uid}")
//                    intoLogRoom(who)
                } else {
                    changeTextView(it.exception.toString())
                }
            }
    }

    private fun changeTextView(text: String) {
//        binding.mainTextView.text = text
    }

    //TODO: not work
    private fun testLogin() {
//        val email = "susu@gmail.com"
        val email = "hsienhsien@gmail.com"
        val password = "888888"

        createUser(email, password)
    }

    private fun createUser(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    changeTextView("Create success, UID: ${it.result.user?.uid}")
                } else {
                    changeTextView(it.exception.toString())
                }
            }
    }
}