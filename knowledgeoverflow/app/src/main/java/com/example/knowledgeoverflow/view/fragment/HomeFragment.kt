package com.example.knowledgeoverflow.view.fragment

import android.content.Context
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentHomeBinding
import com.example.knowledgeoverflow.view.activity.LoginActivity
import com.example.knowledgeoverflow.viewmodel.fragment.HomeViewModel
import com.example.knowledgeoverflow.widget.extention.startActivityWithFinish
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = getViewModel(HomeViewModel::class)

    override fun init() {

    }

    override fun observerViewModel() {
        with(viewModel){
            onLogoutEvent.observe(this@HomeFragment, {
                delete()
                activity?.let { it1 -> startActivityWithFinish(it1, LoginActivity::class.java) }
            })
            onQuestionEvent.observe(this@HomeFragment, {

            })
            onAnswerEvent.observe(this@HomeFragment, {

            })
            onCommentEvent.observe(this@HomeFragment, {

            })
            onChangeEvent.observe(this@HomeFragment,{
                
            })
        }
    }

}