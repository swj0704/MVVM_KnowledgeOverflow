package com.example.knowledgeoverflow.viewmodel.fragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.room.DataBase
import com.example.knowledgeoverflow.widget.SingleLiveEvent

class HomeViewModel(val context: Context) : BaseViewModel() {
    val nickname = MutableLiveData<String>()

    private val dataBase = DataBase.getInstance(context)!!.dao()

    val onLogoutEvent = SingleLiveEvent<Unit>()
    val onCommentEvent = SingleLiveEvent<Unit>()
    val onAnswerEvent = SingleLiveEvent<Unit>()
    val onQuestionEvent = SingleLiveEvent<Unit>()
    val onChangeEvent = SingleLiveEvent<Unit>()

    init {
        nickname.value = dataBase.getAll()[0].name
    }

    fun logout(){
        onLogoutEvent.call()
    }

    fun delete(){
        dataBase.delete()
    }

    fun showComment(){
        onCommentEvent.call()
    }

    fun showAnswer(){
        onAnswerEvent.call()
    }

    fun showQuestion(){
        onQuestionEvent.call()
    }

    fun changeNickname(){
        onChangeEvent.call()
    }
}