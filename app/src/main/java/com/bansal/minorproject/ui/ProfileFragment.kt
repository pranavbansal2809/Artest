package com.bansal.minorproject.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_profile, container, false)

        itemView.rvRecentGigs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rvRecentGigs.adapter = RecentGigsRecyclerAdapter()

        return itemView
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}
