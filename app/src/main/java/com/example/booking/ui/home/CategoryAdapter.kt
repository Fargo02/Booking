package com.example.booking.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.databinding.CategoriesItemBinding
import com.example.booking.domain.model.CategoryItems

class CategoryAdapter(
    private val clickListener: CategoryClickListener
): RecyclerView.Adapter<CategoryViewHolder>() {

    var categories = ArrayList<CategoryItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)
        return CategoryViewHolder(CategoriesItemBinding.inflate(layoutInspector, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], clickListener, position)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    interface CategoryClickListener {
        fun onCategoryClick(categories: CategoryItems, position: Int)
    }
}