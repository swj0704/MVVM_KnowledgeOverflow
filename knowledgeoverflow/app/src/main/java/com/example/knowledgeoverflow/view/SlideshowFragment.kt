package com.example.knowledgeoverflow.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSlideshowBinding
import com.example.knowledgeoverflow.viewmodel.SlideshowViewModel

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding, SlideshowViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_slideshow

    override val viewModel: SlideshowViewModel
        get() = SlideshowViewModel()

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }


}