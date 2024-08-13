package com.example.booking.ui.main

import com.example.booking.data.dto.CategoryItems
import com.example.booking.domain.model.Category

sealed interface CategoryState {
    object Loading : CategoryState

    data class Content(
        val movies: List<CategoryItems>
    ) : CategoryState

    data class Error(
        val message: String
    ) : CategoryState

    data class Empty(
        val message: String
    ) : CategoryState
}