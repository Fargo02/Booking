package com.example.booking.domain.api

import com.example.booking.data.dto.CategoryItems

interface CategoryInteractor {

    fun getCategory(consume: CategoryConsumer)

    interface CategoryConsumer {
        fun consume(answer: List<CategoryItems>?)
    }
}