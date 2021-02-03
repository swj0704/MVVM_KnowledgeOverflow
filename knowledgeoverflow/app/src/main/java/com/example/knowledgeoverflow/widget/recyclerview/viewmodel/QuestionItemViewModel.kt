package com.example.knowledgeoverflow.widget.recyclerview.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.widget.SingleLiveEvent

class QuestionItemViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()
    val theme = MutableLiveData<String>()

    val onDetailEvent = SingleLiveEvent<Unit>()

    fun bind(item : QuestionResponse){
        Log.d("Show View", "TEST")
        title.value = item.title
        theme.value = item.theme
    }

    fun detail(){
        onDetailEvent.call()
    }
}