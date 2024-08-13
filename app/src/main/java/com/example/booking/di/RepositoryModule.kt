package com.practicum.mymovies.di


import com.example.booking.data.CategoryRepositoryImpl
import com.example.booking.domain.api.CategoryRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }
}