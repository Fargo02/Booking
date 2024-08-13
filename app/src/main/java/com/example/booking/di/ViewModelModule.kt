package com.practicum.mymovies.di

import com.example.booking.ui.detail.view_model.DetailViewModel
import com.example.booking.ui.main.view_model.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        DetailViewModel()
    }

    viewModel {
        MainViewModel(get())
    }

}