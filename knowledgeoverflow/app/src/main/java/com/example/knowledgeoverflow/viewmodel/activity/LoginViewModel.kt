package com.example.knowledgeoverflow.viewmodel.activity

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.knowledgeoverflow.network.DTO.GetResponse
import com.example.knowledgeoverflow.network.DTO.UserResponse
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val service: GetAPI, private val context: Context) : BaseViewModel() {
    val onSignUpEvent = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkLogin() {
        val sweetAlertDialog =
                SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        sweetAlertDialog.progressHelper.barColor = Color.parseColor("#0DE930")
        sweetAlertDialog
                .setTitleText("로그인 중")
                .setCancelable(false)
        sweetAlertDialog.show()
        if (email.value!!.isNotEmpty() && password.value!!.isNotEmpty()) {
            service.getUser(email = email.value, password = password.value).enqueue(object : Callback<GetResponse<UserResponse>> {
                override fun onResponse(
                        call: Call<GetResponse<UserResponse>>,
                        response: Response<GetResponse<UserResponse>>
                ) {
                    sweetAlertDialog.dismiss()
                    if (response.body()!!.status == 200) {
                        onSuccessEvent.call()
                    } else {
                        onFailEvent.call()
                    }
                }

                override fun onFailure(call: Call<GetResponse<UserResponse>>, t: Throwable) {
                    Log.d("Fail Login", t.toString())
                    onErrorEvent.call()
                }

            })
        }
    }

    fun goSignUp(){
        onSignUpEvent.call()
    }

}