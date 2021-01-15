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
import com.example.knowledgeoverflow.room.DataBase
import com.example.knowledgeoverflow.room.UserDataBase
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val service: GetAPI, private val context: Context) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkLogin() {
        Log.d("TEST" ,"T")
        if (email.value != null && password.value != null) {
            if (email.value!!.isNotEmpty() && password.value!!.isNotEmpty()) {
                service.getUser(email = email.value, password = password.value).enqueue(object : Callback<GetResponse<UserResponse>> {
                    override fun onResponse(
                            call: Call<GetResponse<UserResponse>>,
                            response: Response<GetResponse<UserResponse>>
                    ) {
                        if (response.body()!!.status == 200) {
                            Log.d("TEST" , "^")
                            val room = DataBase.getInstance(context)!!.dao()
                            val user = response.body()!!.result
                            room.delete()
                            room.insert(UserDataBase(id = user[0].id, email = user[0].email, password = user[0].password, join_time = user[0].join_time, name = user[0].name))
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
            } else {
                onErrorEvent.call()
            }
        } else {
            onErrorEvent.call()
        }

    }
    fun goSignUp(){
        onSignUpEvent.call()
    }

}