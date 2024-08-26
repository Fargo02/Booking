package com.example.booking.data.search

import com.example.booking.data.dto.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("master/app/src/main/java/com/example/booking/database/location.json")
    fun getCategory(): Call<CategoryResponse>

}