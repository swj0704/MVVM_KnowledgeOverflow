package com.example.knowledgeoverflow.view.activity

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivitySignUpBinding
import com.example.knowledgeoverflow.network.api.AddAPI
import com.example.knowledgeoverflow.network.api.CheckAPI
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.viewmodel.activity.SignUpViewModel
import org.koin.android.ext.android.get

class SignUpActivity : BaseActivity<SignUpViewModel, ActivitySignUpBinding>() {

    private val addAPI : AddAPI = get()
    private val getAPI : GetAPI = get()
    private val checkAPI : CheckAPI = get()

    override val resource: Int
        get() = R.layout.activity_sign_up
    override val viewModel: SignUpViewModel
        get() = SignUpViewModel(getAPI, addAPI, checkAPI)

    override fun init() {}

    override fun observerViewModel() {

    }

}