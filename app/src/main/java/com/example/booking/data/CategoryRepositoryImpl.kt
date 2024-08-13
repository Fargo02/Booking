package com.example.booking.data

import android.util.Log
import com.example.booking.data.dto.CategoryItems
import com.example.booking.data.dto.CategoryRequest
import com.example.booking.data.dto.CategoryResponse
import com.example.booking.domain.api.CategoryRepository

class CategoryRepositoryImpl(
    private val networkClient: NetworkClient
): CategoryRepository {
    override fun getCategory(): List<CategoryItems> {
        val response = networkClient.doRequest(CategoryRequest())
        return when (response.resultCode) {
            204 -> {
                Log.i("ErrorRequest", "Ошибка 204")
                emptyList()
            }
            200 -> {
                (response as CategoryResponse).item.map {
                    CategoryItems(
                        category = it.category,
                        data = it.data
                    )
                }
            }
            else -> {
                Log.i("ErrorRequest", "Ошибка сервера")
                emptyList()
            }
        }
    }
}