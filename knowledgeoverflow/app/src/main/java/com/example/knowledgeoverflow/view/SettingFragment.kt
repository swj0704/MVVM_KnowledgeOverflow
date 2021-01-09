package com.example.knowledgeoverflow.view

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSettingBinding
import com.example.knowledgeoverflow.viewmodel.SettingViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_setting

    override val viewModel: SettingViewModel
        get() = SettingViewModel()

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }



}
