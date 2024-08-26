package com.example.booking.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booking.R
import com.example.booking.databinding.LocationItemBinding
import com.example.booking.domain.model.CategoryItems

class LocationViewHolder(
    private val binding: LocationItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: CategoryItems) {
        binding.title.text = model.name
        binding.description.text = "пусто"
        binding.estimation.text = model.rating.toString()
        binding.price.text = model.cost.toString()
        binding.period.text = "/night"
        Glide.with(binding.locationImage.context)
            .load(model.url)
            .placeholder(R.drawable.placeholder)
            .into(binding.locationImage)
    }
}