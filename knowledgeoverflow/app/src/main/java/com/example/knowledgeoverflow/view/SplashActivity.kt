package com.example.knowledgeoverflow.view

import android.os.Handler
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivitySplashBinding
import com.example.knowledgeoverflow.viewmodel.SplashViewModel
import com.example.knowledgeoverflow.widget.extention.startActivityWithFinish

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {
    override val resource: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = SplashViewModel()

    override fun init() {

    }

    override fun observerViewModel() {
        Handler().postDelayed({
            //           startActivityWithFinish(this@SplashActivity, MainActivity::class.java)
        }, 3000)
    }


}