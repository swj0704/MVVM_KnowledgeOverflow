package com.example.knowledgeoverflow.view.activity

import android.content.Intent
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityLoginBinding
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.viewmodel.activity.LoginViewModel
import org.koin.android.ext.android.get

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    private val service : GetAPI = get()

    override val resource: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = LoginViewModel(service, this@LoginActivity)

    override fun init() {}

    override fun observerViewModel() {
        with(viewModel){
            onSuccessEvent.observe(this@LoginActivity, {
                val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.SUCCESS_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("로그인이 완료되었습니다")
                    .setConfirmClickListener {
                        dialog.dismiss()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
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
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
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