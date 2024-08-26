package com.example.booking.data

import android.util.Log
import com.example.booking.domain.model.CategoryItems
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
                        name = it.name,
                        rating = it.rating,
                        site = it.site,
                        address = it.address,
                        cost = it.cost,
                        url = it.url
                    )
                }
            }
            else -> {
                Log.i("ErrorRequest", "Ошибка сервера ${response.resultCode}")
                emptyList()
            }
        }
    }
}