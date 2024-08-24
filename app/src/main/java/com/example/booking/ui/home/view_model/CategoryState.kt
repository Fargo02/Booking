package com.example.booking.ui.home.view_model

import com.example.booking.domain.model.CategoryItems

sealed interface CategoryState {
    object Loading : CategoryState

    data class Content(
        val categoryItems: List<CategoryItems>
    ) : CategoryState

    data class Error(
        val message: String
    ) : CategoryState

    data class Empty(
        val message: String
    ) : CategoryState
}