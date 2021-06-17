package com.example.hw10android.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw10android.R

class HomeFragment : Fragment(R.layout.fragment_home){

    private lateinit var firstname : TextView
    private lateinit var lastname : TextView
    private lateinit var age: TextView
    private lateinit var email: TextView
    private lateinit var image : ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstname = view.findViewById(R.id.firstName)
        lastname = view.findViewById(R.id.lastName)
        age = view.findViewById(R.id.age)
        email = view.findViewById(R.id.email)
        image = view.findViewById(R.id.avatar)

    }

    override fun onResume() {
        super.onResume()

        val prefs = activity?.getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        firstname.text = prefs?.getString("FIRSTNAME", "not set")
        lastname.text = prefs?.getString("LASTNAME", "not set")
        age.text = prefs?.getString("AGE", "not set")
        email.text = prefs?.getString("EMAIL", "not set")

        Glide.with(this)
            .load(prefs?.getString("URL", "not set"))
            .centerCrop()
            .placeholder(R.drawable.noimg)
            .into(image)
    }
}