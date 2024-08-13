package com.example.booking.domain.api

import com.example.booking.domain.model.CategoryItems


interface CategoryRepository {

    fun getCategory(): List<CategoryItems>

}