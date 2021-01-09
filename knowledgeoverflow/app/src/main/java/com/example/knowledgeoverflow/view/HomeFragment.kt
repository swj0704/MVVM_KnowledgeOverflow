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
import com.example.knowledgeoverflow.databinding.FragmentHomeBinding
import com.example.knowledgeoverflow.viewmodel.HomeViewModel

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