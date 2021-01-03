package com.example.knowledgeoverflow.viewmodel

import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.widget.SingleLiveEvent

class SplashViewModel : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()

    init {
        onSuccessEvent.call()
    }
}