package com.bansal.minorproject.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.layout_recent_gig.view.*
import java.util.*

class RecentGigsRecyclerAdapter : RecyclerView.Adapter<RecentGigsRecyclerAdapter.RecentGigsViewHolder> () {

    inner class RecentGigsViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        private val cvGigBackground = itemView.cvGigBackground
        private val random = Random()

        internal fun bindView() {
            val color = Color.argb(
                255,
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            )
            cvGigBackground.setCardBackgroundColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = RecentGigsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recent_gig, parent, false))

    override fun onBindViewHolder(holder: RecentGigsViewHolder, position: Int) {
        holder.bindView()
    }

    override fun getItemCount() = 7
}