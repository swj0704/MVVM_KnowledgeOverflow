package com.example.knowledgeoverflow.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityLoginBinding
import com.example.knowledgeoverflow.network.GetAPI
import com.example.knowledgeoverflow.viewmodel.LoginViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    private val service : GetAPI = get()

    override val resource: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = LoginViewModel(service)

    override fun init() {}

    override fun observerViewModel() {
        with(viewModel){
            onLoginEvent.observe(this@LoginActivity, {

            })
            onFailEvent.observe(this@LoginActivity, {
                
            })
            onSignUpEvent.observe(this@LoginActivity, {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            })
        }
    }


}