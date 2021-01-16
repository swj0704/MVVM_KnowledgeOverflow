package com.example.knowledgeoverflow.view.fragment

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSettingBinding
import com.example.knowledgeoverflow.viewmodel.fragment.SettingViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_setting

    override val viewModel: SettingViewModel
        get() = getViewModel(SettingViewModel::class)

    override fun init() {

    }

    override fun observerViewModel() {

    }



}
