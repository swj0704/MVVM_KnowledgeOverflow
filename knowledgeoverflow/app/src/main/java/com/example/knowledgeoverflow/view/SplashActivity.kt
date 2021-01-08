package com.example.knowledgeoverflow.view

import android.content.Intent
import android.os.Handler
import androidx.lifecycle.Observer
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivitySplashBinding
import com.example.knowledgeoverflow.viewmodel.SplashViewModel
import com.example.knowledgeoverflow.widget.extention.startActivityWithFinish

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {
    override val resource: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = SplashViewModel(this@SplashActivity)

    override fun init() {

    }

    override fun observerViewModel() {
        val handler = Handler()
        var runnable : Runnable

        with(viewModel){
            onSuccessEvent.observe(this@SplashActivity, {
                runnable = Runnable {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                }
                handler.postDelayed(runnable, 2000)
            })
            onFailEvent.observe(this@SplashActivity, {
                runnable = Runnable {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }
                handler.postDelayed(runnable, 2000)
            })
        }
    }


}