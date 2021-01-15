package com.example.knowledgeoverflow.viewmodel.activity

import android.content.Context
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.room.DataBase
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import com.example.knowledgeoverflow.widget.`object`.SharedPreferencesManager

class SplashViewModel(val context : Context) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()

    init {
        if (DataBase.getInstance(context)!!.dao().getAll().isNotEmpty()) onSuccessEvent.call()
        else onFailEvent.call()
    }
}