package com.example.pop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_registration_second.view.*

class RegistrationSecond : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_registration_second, container, false)
        view.layoutRegistrationButtonRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_registrationSecond_to_registrationThird)
        }
        return view
    }
}
