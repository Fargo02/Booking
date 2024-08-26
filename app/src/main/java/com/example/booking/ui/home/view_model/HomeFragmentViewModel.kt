package com.example.booking.ui.home.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booking.domain.api.CategoryInteractor
import com.example.booking.domain.model.CategoryItems

class HomeFragmentViewModel(
    private val interactor: CategoryInteractor
): ViewModel() {

    private val stateLiveData = MutableLiveData<CategoryState>()
    fun observeState(): LiveData<CategoryState> = stateLiveData

    fun doRequest() {
        CategoryState.Loading
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

    fun toggleCategoryButton(categories: CategoryItems, position: Int) {
        updateMovieContent(categories.copy(isSelected = !categories.isSelected), position)
    }

    private fun updateMovieContent(newCategories: CategoryItems, position: Int) {
        val currentState = stateLiveData.value

        if (currentState is CategoryState.Content) {
            stateLiveData.value = CategoryState.Content(
                currentState.categoryItems.toMutableList().also {
                    it[position] = newCategories
                }
            )
        }
    }
}