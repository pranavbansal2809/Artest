package com.bansal.minorproject.ui.homescreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.bansal.minorproject.R
import com.bansal.minorproject.ui.login.viewmodels.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_musician_homepage.view.*

/**
 * A simple [Fragment] subclass.
 */
class MusicianHomepageFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_musician_homepage, container, false)

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
                when(authenticationState) {
                    LoginViewModel.AuthenticationState.AUTHENTICATED ->
                        setupPage(itemView)
                    LoginViewModel.AuthenticationState.UNAUTHENTICATED ->
                        findNavController().navigate(R.id.action_home_fragment_to_login_fragment)
                    LoginViewModel.AuthenticationState.INVALID_AUTHENTICATION -> {}
                    else -> { /*Do Nothing*/ }
                }
        })

        return itemView
    }

    private fun setupPage(itemView: View) {
        itemView.rvPickedList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rvPickedList.adapter = PickedRecyclerAdapter()

        itemView.rvRecentList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        itemView.rvRecentList.adapter = RecentRecyclerAdapter()

        itemView.ivProfile.apply {
            borderWidth = 0f
            setOnClickListener {
                findNavController().navigate(R.id.action_home_fragment_to_profile_fragment)
            }
        }
    }
}
