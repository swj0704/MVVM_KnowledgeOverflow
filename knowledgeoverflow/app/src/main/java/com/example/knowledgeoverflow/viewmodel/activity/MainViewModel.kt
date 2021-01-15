package com.example.knowledgeoverflow.viewmodel.activity

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.room.DataBase

class MainViewModel(val context: Context) : BaseViewModel(){
    val email : String
    val nickName : String

    init {
        val room = DataBase.getInstance(context)!!.dao()

        email = room.getAll()[0].email
        nickName = room.getAll()[0].name
    }

}