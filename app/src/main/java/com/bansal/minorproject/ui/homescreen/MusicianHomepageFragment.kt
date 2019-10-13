package com.bansal.minorproject.ui.homescreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.bansal.minorproject.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_musician_homepage.view.*

/**
 * A simple [Fragment] subclass.
 */
class MusicianHomepageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(FirebaseAuth.getInstance().currentUser == null)
            findNavController().navigate(R.id.action_home_fragment_to_login_fragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_musician_homepage, container, false)

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

        return itemView
    }


}
