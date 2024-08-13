package com.practicum.mymovies.di

import com.example.booking.domain.api.CategoryInteractor
import com.example.booking.domain.impl.GetCategoryInteractorImpl
import org.koin.dsl.module


val interactorModule = module {

    single<CategoryInteractor> {
        GetCategoryInteractorImpl(get())
    }
}