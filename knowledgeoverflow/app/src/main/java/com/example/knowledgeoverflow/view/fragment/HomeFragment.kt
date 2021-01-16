package com.example.knowledgeoverflow.view.fragment

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentHomeBinding
import com.example.knowledgeoverflow.viewmodel.fragment.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override fun init() {

    }

    override fun observerViewModel() {

    }

}