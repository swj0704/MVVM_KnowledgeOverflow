package com.example.knowledgeoverflow.viewmodel.activity

import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.network.DTO.GetResponse
import com.example.knowledgeoverflow.network.DTO.UserResponse
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.DTO.Status
import com.example.knowledgeoverflow.network.api.AddAPI
import com.example.knowledgeoverflow.network.api.CheckAPI
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpViewModel(private val getAPI: GetAPI, private val addAPI: AddAPI, private val checkAPI: CheckAPI) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val nickname = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val onNickNameDuplicateEvent = SingleLiveEvent<Unit>()
    val onNickNameSwearEvent = SingleLiveEvent<Unit>()
    val onCheckNickname = SingleLiveEvent<Unit>()
    val onEmailDuplicateEvent = SingleLiveEvent<Unit>()
    val onNotEmailDuplicateEvent = SingleLiveEvent<Unit>()
    var isDuplicateNickname : Boolean = true
    var isSwearNickname : Boolean = true
    var isDuplicateEmail : Boolean = true

    fun checkEmail(){
        if(checkText(email.value)) {
            getAPI.getUser(email = email.value).enqueue(object : Callback<GetResponse<UserResponse>> {
                override fun onResponse(
                        call: Call<GetResponse<UserResponse>>,
                        response: Response<GetResponse<UserResponse>>
                ) {
                    Log.d("STATUS", response.body()!!.status.toString())
                    isDuplicateEmail = if (response.body()!!.status == 200) {
                        onEmailDuplicateEvent.call()
                        true
                    } else {
                        onNotEmailDuplicateEvent.call()
                        false
                    }
                }

                override fun onFailure(call: Call<GetResponse<UserResponse>>, t: Throwable) {
                    onErrorEvent.call()
                }

            })
        }
    }

    fun checkNickName(){
        if(checkText(nickname.value)) {
            getAPI.getUser(name = nickname.value).enqueue(object : Callback<GetResponse<UserResponse>> {
                override fun onResponse(
                        call: Call<GetResponse<UserResponse>>,
                        response: Response<GetResponse<UserResponse>>
                ) {
                    Log.d("STATUS", response.body()!!.status.toString())
                    if (response.body()!!.status == 200) {
                        onNickNameDuplicateEvent.call()
                        isDuplicateNickname = true
                    } else {
                        isDuplicateNickname = false
                        nickname.value?.let { checkAPI.checkSwearing(it).enqueue(object : Callback<GetResponse<String>>{
                            override fun onResponse(call: Call<GetResponse<String>>, response: Response<GetResponse<String>>) {
                                if(response.body()!!.status == 200){
                                    isSwearNickname = true
                                    onNickNameSwearEvent.call()
                                } else {
                                    isSwearNickname = false
                                    onCheckNickname.call()
                                }
                            }

                            override fun onFailure(call: Call<GetResponse<String>>, t: Throwable) {
                                onErrorEvent.call()
                            }

                        }) }
                    }
                }

                override fun onFailure(call: Call<GetResponse<UserResponse>>, t: Throwable) {
                    onErrorEvent.call()
                }

            })
        }
    }

    fun signUp(){
        if(isDuplicateEmail || isDuplicateNickname){
            onFailEvent.call()
        } else {
            if(password.value != null) {
                addAPI.addUser(email = email.value!!, name = nickname.value!!, password = password.value!!)
                    .enqueue(object : Callback<Status> {
                        override fun onResponse(
                            call: Call<Status>,
                            response: Response<Status>
                        ) {
                            if(response.body()!!.status == 200){
                                onSuccessEvent.call()
                            } else {
                                onFailEvent.call()
                            }
                        }

                        override fun onFailure(call: Call<Status>, t: Throwable) {
                            onErrorEvent.call()
                        }

                    })

            } else {
                onFailEvent.call()
            }
        }
    }

    private fun checkText(text : String?) : Boolean{
        return text?.isNotEmpty() ?: false
    }

}