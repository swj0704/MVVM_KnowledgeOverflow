package com.example.knowledgeoverflow.view

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

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }


}