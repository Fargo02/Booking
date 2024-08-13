package com.example.booking.data.dto


data class CategoryItems(
    val category: String,
    val data: List<CategoryData>
)

data class CategoryData(
    val address: String,
    val cost: Int,
    val imageUrl: String,
    val name: String,
    val rating: Double,
    val site: String
)