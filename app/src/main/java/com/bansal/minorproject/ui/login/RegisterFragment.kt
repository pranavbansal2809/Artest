package com.bansal.minorproject.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_register, container, false)

        itemView.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_register_fragment_to_login_fragment)
        }

        itemView.btnSignUp.setOnClickListener {
            if(itemView.etEmail.text.toString()!=""&& itemView.etPassword.text.toString()!="") {
              val bundle = Bundle().apply {
              putString("email", etEmail.text.toString())
              putString("password", etPassword.text.toString())
              }

              findNavController().navigate(R.id.action_register_fragment_to_information_fragment, bundle)
            }else{
                Toast.makeText(itemView.context,"Enter Email and Password", Toast.LENGTH_SHORT).show()
            }

        }

        return itemView
    }


}
