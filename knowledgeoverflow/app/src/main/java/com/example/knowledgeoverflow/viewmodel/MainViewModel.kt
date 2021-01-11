package com.example.knowledgeoverflow.viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.base.BaseViewModel

class MainViewModel(val context: Context) : BaseViewModel(){
    val email = MutableLiveData<String>()
    val nickName = MutableLiveData<String>()


}