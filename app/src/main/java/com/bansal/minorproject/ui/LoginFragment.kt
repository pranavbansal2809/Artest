package com.bansal.minorproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.fragment_login.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}
