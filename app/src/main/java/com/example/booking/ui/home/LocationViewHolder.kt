package com.example.booking.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booking.databinding.LocationItemBinding
import com.example.booking.domain.model.CategoryItems

class LocationViewHolder(
    private val binding: LocationItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: CategoryItems) {
        Glide.with(binding.locationImage.context)

    }
}