package com.example.booking.utils

import android.app.Application
import com.practicum.mymovies.di.dataModule
import com.practicum.mymovies.di.interactorModule
import com.practicum.mymovies.di.repositoryModule
import com.practicum.mymovies.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }
}