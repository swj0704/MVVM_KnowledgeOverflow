package com.example.knowledgeoverflow.view.activity

import android.content.Intent
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivitySignUpBinding
import com.example.knowledgeoverflow.network.api.AddAPI
import com.example.knowledgeoverflow.network.api.CheckAPI
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.viewmodel.activity.SignUpViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SignUpActivity : BaseActivity<SignUpViewModel, ActivitySignUpBinding>() {

    override val resource: Int
        get() = R.layout.activity_sign_up
    override val viewModel: SignUpViewModel
        get() = getViewModel(SignUpViewModel::class)

    override fun init() {}

    override fun observerViewModel() {
        with(viewModel){
            onEmailDuplicateEvent.observe(this@SignUpActivity, {
                binding.signUpIDLayout.error = "중복된 이메일입니다"
            })
            onNotEmailDuplicateEvent.observe(this@SignUpActivity, {
                binding.signUpIDLayout.error = null
            })
            onNickNameDuplicateEvent.observe(this@SignUpActivity, {
                binding.signUpNameLayout.error = "중복된 닉네임입니다"
            })
            onNickNameSwearEvent.observe(this@SignUpActivity, {
                binding.signUpNameLayout.error = "욕설 사용 금지"
            })
            onCheckNickname.observe(this@SignUpActivity, {
                binding.signUpNameLayout.error = null
            })
            onSuccessEvent.observe(this@SignUpActivity, {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.SUCCESS_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("회원가입이 성공하였습니다")
                        .setConfirmClickListener {
                            dialog.dismiss()
                            finish()
                        }
                        .show()
            })
            onFailEvent.observe(this@SignUpActivity, {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.ERROR_TYPE)

                dialog.setCancelable(false)

                dialog.setTitleText("회원가입이 실패하였습니다")
                        .setConfirmClickListener {
                            dialog.dismiss()
                        }
                        .show()
            })
            onErrorEvent.observe(this@SignUpActivity, {
                val dialog = SweetAlertDialog(this@SignUpActivity, SweetAlertDialog.ERROR_TYPE)

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