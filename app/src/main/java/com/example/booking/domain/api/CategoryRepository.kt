package com.example.booking.domain.api

import com.example.booking.data.dto.CategoryItems


interface CategoryRepository {

    fun getCategory(): List<CategoryItems>

}