package com.example.knowledgeoverflow.viewmodel.activity

import android.content.Context
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import com.example.knowledgeoverflow.widget.`object`.SharedPreferencesManager

class SplashViewModel(val context : Context) : BaseViewModel() {

    init {
        if (SharedPreferencesManager.getUserUid(context) != null) onSuccessEvent.call()
        else onFailEvent.call()
    }
}