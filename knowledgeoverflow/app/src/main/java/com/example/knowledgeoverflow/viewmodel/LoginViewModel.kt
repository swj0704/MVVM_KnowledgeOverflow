package com.example.knowledgeoverflow.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.di.myModule
import com.example.knowledgeoverflow.network.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Retrofit

class LoginViewModel(val service : GetAPI) : BaseViewModel() {
    val login = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkLogin(){

    }
}