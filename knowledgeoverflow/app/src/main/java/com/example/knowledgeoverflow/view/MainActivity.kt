package com.example.knowledgeoverflow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityMainBinding
import com.example.knowledgeoverflow.viewmodel.MainViewModel

class MainActivity() : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val resource: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() = MainViewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

}