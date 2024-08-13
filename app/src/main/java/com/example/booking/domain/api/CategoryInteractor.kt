package com.example.booking.domain.api

import com.example.booking.domain.model.CategoryItems

interface CategoryInteractor {

    fun getCategory(consume: CategoryConsumer)

    interface CategoryConsumer {
        fun consume(answer: List<CategoryItems>?)
    }
}