package com.practicum.mymovies.di

import com.example.booking.data.NetworkClient
import com.example.booking.data.search.Api
import com.example.booking.data.search.RetrofitNetworkClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {
    single<Api> {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Fargo02/JetpackCompose/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get())
    }

}