package com.bansal.minorproject.ui.homescreen

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bansal.minorproject.R
import kotlinx.android.synthetic.main.layout_picked.view.*

class PickedRecyclerAdapter : RecyclerView.Adapter<PickedRecyclerAdapter.PickedViewHolder> () {
    inner class PickedViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        private val ivEstablishmentImage = itemView.ivEstablishmentImage
        private val images = arrayOf(R.drawable.establishment1, R.drawable.establishment2)

        fun bindView(position: Int) {
            ivEstablishmentImage.setBackgroundResource(images[position %2])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = PickedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_picked, parent, false))

    override fun onBindViewHolder(holder: PickedViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = 5
}