package com.example.knowledgeoverflow.viewmodel.fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.room.DataBase
import com.example.knowledgeoverflow.widget.SingleLiveEvent

class SettingViewModel(val context: Context) : BaseViewModel() {
    val nickname = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()

    private val dataBase = DataBase.getInstance(context)!!.dao()

    val onLogoutEvent = SingleLiveEvent<Unit>()
    val onChangePasswordEvent = SingleLiveEvent<Unit>()
    val onChangeNicknameEvent = SingleLiveEvent<Unit>()
    val onDeleteEvent = SingleLiveEvent<Unit>()

    init {
        nickname.value = dataBase.getAll()[0].name
        pwd.value = dataBase.getAll()[0].password
    }

    fun deleteUser(){
        onDeleteEvent.call()
    }

    fun logout(){
        onLogoutEvent.call()
    }

    fun delete(){
        dataBase.delete()
    }

    fun changePassword(){
        onChangePasswordEvent.call()
    }

    fun changeNickname(){
        onChangeNicknameEvent.call()
    }
}