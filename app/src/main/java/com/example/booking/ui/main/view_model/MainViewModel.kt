package com.example.booking.ui.main.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booking.domain.model.CategoryItems
import com.example.booking.domain.api.CategoryInteractor
import com.example.booking.ui.main.CategoryState

class MainViewModel(
    private val interactor: CategoryInteractor
): ViewModel() {

    private val stateLiveData = MutableLiveData<CategoryState>()
    fun observeState(): LiveData<CategoryState> = stateLiveData

    fun doRequest() {
        interactor.getCategory(object : CategoryInteractor.CategoryConsumer{
            override fun consume(answer: List<CategoryItems>?) {
                val category = mutableListOf<CategoryItems>()
                if (answer != null) {
                    stateLiveData.postValue(
                        CategoryState.Content(
                            category
                        )
                    )
                    category.addAll(answer)
                }

            }
        })
    }
}