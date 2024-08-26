package com.example.booking.domain.model


data class CategoryItems(
    val category: String,
    val name: String,
    val rating: Double,
    val site: String,
    val address: String,
    val cost: Int,
    val isSelected: Boolean = false,
    val url: String,
)