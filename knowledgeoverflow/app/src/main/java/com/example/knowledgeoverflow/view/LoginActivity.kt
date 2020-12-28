package com.example.knowledgeoverflow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityLoginBinding
import com.example.knowledgeoverflow.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override val resource: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = LoginViewModel()

    override fun initStartView() {}

    override fun initDataBinding() {}

    override fun initAfterBinding() {

    }


}