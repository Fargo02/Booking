package com.example.booking.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.databinding.LocationItemBinding
import com.example.booking.domain.model.CategoryItems

class LocationAdapter(): RecyclerView.Adapter<LocationViewHolder>() {

    var locations = ArrayList<CategoryItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)
        return LocationViewHolder(LocationItemBinding.inflate(layoutInspector, parent, false))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) = holder.bind(locations[position])

    override fun getItemCount(): Int = locations.size

}