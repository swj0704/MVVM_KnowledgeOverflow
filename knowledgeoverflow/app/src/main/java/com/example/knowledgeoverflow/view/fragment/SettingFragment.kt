package com.example.knowledgeoverflow.view.fragment

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSettingBinding
import com.example.knowledgeoverflow.view.activity.LoginActivity
import com.example.knowledgeoverflow.viewmodel.fragment.SettingViewModel
import com.example.knowledgeoverflow.widget.extention.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_setting

    override val viewModel: SettingViewModel
        get() = getViewModel(SettingViewModel::class)

    override fun init() {

    }

    override fun observerViewModel() {
        with(viewModel){
            onLogoutEvent.observe(this@SettingFragment, {
                delete()
                activity?.let { it1 -> startActivityWithFinish(it1, LoginActivity::class.java) }
            })
            onQuestionEvent.observe(this@SettingFragment, {

            })
            onAnswerEvent.observe(this@SettingFragment, {

            })
            onCommentEvent.observe(this@SettingFragment, {

            })
            onChangeEvent.observe(this@SettingFragment, {

            })
        }
    }



}
