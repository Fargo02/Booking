package com.example.booking.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booking.databinding.FragmentHomeBinding
import com.example.booking.domain.model.CategoryItems
import com.example.booking.ui.home.view_model.HomeFragmentViewModel
import com.example.booking.ui.home.view_model.CategoryState
import com.example.booking.utils.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment(): BindingFragment<FragmentHomeBinding>() {

    private val categoriesAdapter= CategoryAdapter (
        object : CategoryAdapter.CategoryClickListener {
            override fun onCategoryClick(categories: CategoryItems, position: Int) {
                viewModel.toggleCategoryButton(categories, position)
            }
        }
    )

    private val locationAdapter = LocationAdapter()

    private var categoryItems = ArrayList<CategoryItems>()

    private val viewModel by viewModel<HomeFragmentViewModel>()

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriesAdapter.categories = categoryItems
        binding.categoriesList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesList.adapter = categoriesAdapter

        locationAdapter.locations = categoryItems
        binding.locationList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.locationList.adapter = locationAdapter

        viewModel.doRequest()

        viewModel.observeState().observe(viewLifecycleOwner){
            render(it)
        }

    }
    private fun render(state: CategoryState) {
        when(state) {
            is CategoryState.Content -> showContent(state.categoryItems)
            is CategoryState.Empty -> TODO()
            is CategoryState.Error -> TODO()
            CategoryState.Loading -> showLoading()
        }
    }
    private fun showContent(categoryList: List<CategoryItems>) {
        binding.shimmerView.stopShimmer()
        categoriesAdapter.categories.clear()
        categoriesAdapter.categories.addAll(categoryList.distinctBy { it.category })
        locationAdapter.locations.addAll(categoryList)
        binding.categoriesList.isVisible = true
        binding.shimmerView.isVisible = false
        locationAdapter.notifyDataSetChanged()
        categoriesAdapter.notifyDataSetChanged()
    }


    private fun showLoading() {
        binding.shimmerView.startShimmer()
    }
}