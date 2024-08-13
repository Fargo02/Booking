package com.example.booking.data

import com.example.booking.data.dto.Response


interface NetworkClient {
    fun doRequest(dto: Any): Response
}