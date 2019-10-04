package com.bansal.minorproject.ui.profilepage

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.layout_recent_gig.view.*
import java.util.*

class RecentGigsRecyclerAdapter : RecyclerView.Adapter<RecentGigsRecyclerAdapter.RecentGigsViewHolder> () {

    inner class RecentGigsViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        private val ivEstablishmentImage = itemView.ivEstablishmentImage
        private val images = arrayOf(R.drawable.establishment1, R.drawable.establishment2)

        internal fun bindView(position: Int) {
            ivEstablishmentImage.setBackgroundResource(images[position % 2])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = RecentGigsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recent_gig, parent, false))

    override fun onBindViewHolder(holder: RecentGigsViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = 7
}