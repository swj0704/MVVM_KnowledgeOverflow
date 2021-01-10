package com.example.knowledgeoverflow.base

import androidx.lifecycle.ViewModel
import com.example.knowledgeoverflow.widget.SingleLiveEvent

open class BaseViewModel : ViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
}