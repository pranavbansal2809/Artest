package com.bansal.minorproject.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.layout_musical_preferences.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    interface ProgressIndicator {
        fun updateProgress()
    }

    private var layout: Int = R.layout.layout_basic_details
    lateinit var progressIndicator: ProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = savedInstanceState?.getInt(LAYOUT_KEY) ?: R.layout.layout_basic_details
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(layout, container, false)

        val btn = itemView.findViewById<Button>(R.id.btnNext)
        btn.setOnClickListener { progressIndicator.updateProgress() }

        return itemView
    }

    companion object {
        private const val LAYOUT_KEY = "Layout"

        @JvmStatic
        fun getInstance(layout: Int) = DetailsFragment().apply {
             arguments = Bundle().apply {
                 putInt(LAYOUT_KEY, layout)
             }
        }
    }
}
