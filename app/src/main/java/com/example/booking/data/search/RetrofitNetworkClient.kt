package com.example.booking.data.search

import android.util.Log
import com.example.booking.data.NetworkClient
import com.example.booking.data.dto.CategoryRequest
import com.example.booking.data.dto.Response

class RetrofitNetworkClient(
    private val service: Api
): NetworkClient {
    override fun doRequest(dto: Any): Response {
        return when (dto) {
            is CategoryRequest -> {
                val response = service.getCategory().execute()
                val body = response.body()
                return if (body != null) {
                    Log.i("Request", "${response.code()}")
                    body.apply { resultCode = response.code() }
                } else {
                    Response().apply { resultCode = response.code() }
                }
            }
            else -> {
                Response().apply { resultCode = 400 }
            }
        }
    }
}