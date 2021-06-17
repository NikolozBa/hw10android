package com.example.hw10android.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hw10android.R

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val namePattern : Regex = Regex("^[a-zA-Z ]+\$")
    private val agePattern : Regex = Regex("^([1-9][0-9]{0,1}|1[10][1-9])\$")
    private val emailPattern: Regex = Regex("^([a-zA-Z0-9]+\\.)*[a-zA-Z0-9]+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]+\$")


    private lateinit var firstname : EditText
    private lateinit var lastname : EditText
    private lateinit var age: EditText
    private lateinit var email: EditText
    private lateinit var imageURL : EditText
    private lateinit var save : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstname = view.findViewById(R.id.firstNameField)
        lastname = view.findViewById(R.id.lastNameField)
        age = view.findViewById(R.id.ageField)
        email = view.findViewById(R.id.emailField)
        imageURL = view.findViewById(R.id.imageField)
        save = view.findViewById(R.id.save)
        val prefs = activity?.getSharedPreferences("Prefs", Context.MODE_PRIVATE)

        save.setOnClickListener {

            var updated = false

            if(firstname.text.matches(namePattern)){
                prefs?.edit()?.putString("FIRSTNAME", firstname.text.toString())?.apply()
                updated = true
            }else if(firstname.text.isNotEmpty()){
                firstname.setError("invalid firstname")
            }


            if (lastname.text.matches(namePattern)){
                prefs?.edit()?.putString("LASTNAME", lastname.text.toString())?.apply()
                updated = true
            }else if(lastname.text.isNotEmpty()){
                lastname.setError("invalid lastname")
            }


            if (age.text.matches(agePattern)){
                prefs?.edit()?.putString("AGE", age.text.toString())?.apply()
                updated = true
            }else if(age.text.isNotEmpty()){
                age.setError("invalid age")
            }


            if (email.text.matches(emailPattern)){
                prefs?.edit()?.putString("EMAIL", email.text.toString())?.apply()
                updated = true
            }else if(email.text.isNotEmpty()){
                email.setError("invalid email")
            }


            if (imageURL.text.isNotEmpty()){
                prefs?.edit()?.putString("URL", imageURL.text.toString())?.apply()
                updated = true
            }

            if(updated){
                Toast.makeText(activity, "Updated Successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}