package com.example.knowledgeoverflow.viewmodel

import android.content.Context
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import com.example.knowledgeoverflow.widget.`object`.SharedPreferencesManager

class SplashViewModel(val context : Context) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()

    init {
        if (SharedPreferencesManager.getUserUid(context) != null) onSuccessEvent.call()
        else onFailEvent.call()
    }
}