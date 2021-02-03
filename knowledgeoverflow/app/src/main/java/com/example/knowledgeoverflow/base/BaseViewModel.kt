package com.example.knowledgeoverflow.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.knowledgeoverflow.widget.SingleLiveEvent

open class BaseViewModel : ViewModel() {

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }

    fun setIsLoadingTrue() {
        isLoading.value = true
    }
    fun setIsLoadingFalse() {
        isLoading.value = false
    }

}