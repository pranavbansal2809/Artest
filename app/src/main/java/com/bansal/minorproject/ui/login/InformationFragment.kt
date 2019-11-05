package com.bansal.minorproject.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.fragment_information.view.*

/**
 * A simple [Fragment] subclass.
 */
class InformationFragment : Fragment() {

    private val layouts = arrayOf(
        R.layout.layout_basic_details,
        R.layout.layout_date_time,
        R.layout.layout_musical_preferences
    )
    private var fragmentNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_information, container, false)

        changeFragment(itemView)

        return itemView
    }

    private fun changeFragment(itemView: View) {
        if(fragmentNumber >= 2)
            return

        val fragment = DetailsFragment.getInstance(layouts[fragmentNumber++])
        fragment.progressIndicator = object: DetailsFragment.ProgressIndicator {
            override fun updateProgress() {
                changeFragment(itemView)
            }
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.fragContainer, fragment)
            .commit()
    }
}
