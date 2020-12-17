package com.example.knowledgeoverflow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivitySplashBinding
import com.example.knowledgeoverflow.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {
    override val resource: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = SplashViewModel()

    override fun initStartView() {
        TODO("Not yet implemented")
    }

    override fun initDataBinding() {
        TODO("Not yet implemented")
    }

    override fun initAfterBinding() {
        TODO("Not yet implemented")
    }


}