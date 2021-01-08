package com.example.knowledgeoverflow.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.DTO.GetResponse
import com.example.knowledgeoverflow.DTO.UserResponse
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.di.myModule
import com.example.knowledgeoverflow.network.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginViewModel(private val service: GetAPI) : BaseViewModel() {
    val onLoginEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkLogin(){
        service.getUser(email = email.value, password = password.value).enqueue(object : Callback<GetResponse<UserResponse>>{
            override fun onResponse(
                call: Call<GetResponse<UserResponse>>,
                response: Response<GetResponse<UserResponse>>
            ) {
                if(response.body()!!.status == 200){
                    onLoginEvent.call()
                } else {
                    onFailEvent.call()
                }
            }

            override fun onFailure(call: Call<GetResponse<UserResponse>>, t: Throwable) {
                Log.d("Fail Login", t.toString())
                onFailEvent.call()
            }

        })
    }

    fun goSignUp(){
        onSignUpEvent.call()
    }
}