package com.example.knowledgeoverflow.viewmodel.fragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.DTO.GetResponse
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlideshowViewModel(private val service: GetAPI, context: Context) : BaseViewModel() {
    val mContext = context

    val goWriteQuestionEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()

    var questionList = ArrayList<QuestionResponse>()

    init {
        getList("상식")
    }

    fun getList(theme : String?){
        service.getQuestion(theme = theme).enqueue(object : Callback<GetResponse<QuestionResponse>>{
            override fun onResponse(call: Call<GetResponse<QuestionResponse>>, response: Response<GetResponse<QuestionResponse>>) {
                if(response.body()!!.status == 200){
                    questionList = response.body()!!.result
                }
            }

            override fun onFailure(call: Call<GetResponse<QuestionResponse>>, t: Throwable) {
                onErrorEvent.call()
            }

        })
    }
    fun getList(theme: String?, text : String?){
        service.getQuestion(theme = theme, title = text).enqueue(object : Callback<GetResponse<QuestionResponse>>{
            override fun onResponse(call: Call<GetResponse<QuestionResponse>>, response: Response<GetResponse<QuestionResponse>>) {
                if(response.body()!!.status == 200){
                    questionList = response.body()!!.result
                }
            }

            override fun onFailure(call: Call<GetResponse<QuestionResponse>>, t: Throwable) {
                onErrorEvent.call()
            }

        })
    }

    fun goWriteQuestion(){
        goWriteQuestionEvent.call()
    }
}