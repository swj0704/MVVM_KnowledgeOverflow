package com.example.knowledgeoverflow.view.activity

import android.content.Intent
import androidx.lifecycle.Observer
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityLoginBinding
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.viewmodel.activity.LoginViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override val resource: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override fun init() {}

    override fun observerViewModel() {
        with(viewModel){
            onSuccessEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.SUCCESS_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("로그인에 성공하였습니다")
                        .setConfirmClickListener {
                            dialog.dismiss()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .show()
            })
            onFailEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("로그인이 실패하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                    }
                    .show()
            })
            onSignUpEvent.observe(this@LoginActivity, {
                startActivity(Intent(applicationContext, SignUpActivity::class.java))
            })
            onErrorEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("오류가 발생하였습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                    }
                    .show()
            })
        }
    }


}