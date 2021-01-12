package com.example.knowledgeoverflow.view.fragment

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentHomeBinding
import com.example.knowledgeoverflow.viewmodel.fragment.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = HomeViewModel()

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }

}