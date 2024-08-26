package com.example.booking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.booking.databinding.FragmentDetailsBinding
import com.example.booking.utils.BindingFragment

class DetailsFragment(): BindingFragment<FragmentDetailsBinding>() {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val LOCATION = "location"
        fun createArgs(locationName: String): Bundle =
            bundleOf(LOCATION to locationName)
        /*
        Создать запрос Details по полученному названию локации,
        соотвественно добавить json файл с информацией
         */
    }
}