package com.bansal.minorproject.ui.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.layout_recent.view.*

class RecentRecyclerAdapter : RecyclerView.Adapter<RecentRecyclerAdapter.RecentViewHolder> () {

    inner class RecentViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        private val ivEstablishmentImage = itemView.ivEstablishmentImage
        private val images = arrayOf(R.drawable.establishment1, R.drawable.establishment2)

        fun bindView(position: Int) {
            ivEstablishmentImage.apply {
                setImageResource(images[position % 2])
                borderWidth = 0f
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = RecentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recent, parent, false))

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = 4
}