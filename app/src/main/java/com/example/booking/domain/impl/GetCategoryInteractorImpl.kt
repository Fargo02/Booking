package com.example.booking.domain.impl

import com.example.booking.domain.api.CategoryInteractor
import com.example.booking.domain.api.CategoryRepository
import java.util.concurrent.Executors

class GetCategoryInteractorImpl(
    private val repository: CategoryRepository
): CategoryInteractor {

    private val executor = Executors.newCachedThreadPool()

    override fun getCategory(consume: CategoryInteractor.CategoryConsumer) {
        executor.execute {
            val resource = repository.getCategory()
            consume.consume(resource)
        }
    }

}