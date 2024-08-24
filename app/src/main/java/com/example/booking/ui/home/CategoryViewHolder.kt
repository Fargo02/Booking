package com.example.booking.ui.home

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.R
import com.example.booking.databinding.CategoriesItemBinding
import com.example.booking.domain.model.CategoryItems
import com.example.booking.ui.home.CategoryAdapter.CategoryClickListener

class CategoryViewHolder(
    private val binding: CategoriesItemBinding,
): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: CategoryItems, clickListener: CategoryClickListener, position: Int) {
        binding.button.text = model.category
        when (model.category) {
            "Отель" -> binding.button.setIconResource(R.drawable.ic_hotel)
            "Homestay" -> binding.button.setIconResource(R.drawable.ic_homestay)
            "Квартира" -> binding.button.setIconResource(R.drawable.ic_apart)
            "Дом" -> binding.button.setIconResource(R.drawable.ic_house)
        }


        binding.button.setOnClickListener {
            binding.button.setBackgroundColor(getColor(model.isSelected))
            clickListener.onCategoryClick(model, position)
        }


    }
    private fun getColor(boolean: Boolean): Int{
        return if (boolean) {
            ContextCompat.getColor(itemView.context, R.color.light_grey)
        } else {
            ContextCompat.getColor(itemView.context, R.color.purple)
        }
    }
}