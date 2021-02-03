package com.example.knowledgeoverflow.viewmodel.fragment

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.DTO.GetResponse
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.network.api.GetAPI
import com.example.knowledgeoverflow.widget.SingleLiveEvent
import com.example.knowledgeoverflow.widget.recyclerview.adapter.QuestionAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlideshowViewModel(private val service: GetAPI, context: Context) : BaseViewModel() {
    private val mContext = context

    val goWriteQuestionEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()

    var questionList = ArrayList<QuestionResponse>()

    var adapter = QuestionAdapter(mContext)

    var item = "상식"

    init {
        setIsLoadingTrue()
    }


    fun onLanguageSpinnerItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        item = (parent.getItemAtPosition(position) as String)
        getList(item)
    }

    fun setList(){
        adapter.setList(questionList)
        adapter.notifyDataSetChanged()
        setIsLoadingFalse()
    }

    fun getList(theme: String?){
        setIsLoadingTrue()
        service.getQuestion(theme = theme).enqueue(object : Callback<GetResponse<QuestionResponse>> {
            override fun onResponse(call: Call<GetResponse<QuestionResponse>>, response: Response<GetResponse<QuestionResponse>>) {
                if (response.body()!!.status == 200) {
                    questionList.clear()
                    for(item in response.body()!!.result){
                        questionList.add(item)
                    }
                    Log.d("ITEM", response.body()!!.toString())
                    setList()
                }
            }

            override fun onFailure(call: Call<GetResponse<QuestionResponse>>, t: Throwable) {
                onErrorEvent.call()
                setIsLoadingFalse()
            }

        })
    }

    fun getList(theme: String?, text: String?){
        service.getQuestion(theme = theme, title = text).enqueue(object : Callback<GetResponse<QuestionResponse>> {
            override fun onResponse(call: Call<GetResponse<QuestionResponse>>, response: Response<GetResponse<QuestionResponse>>) {
                if (response.body()!!.status == 200) {
                    questionList.clear()
                    for(item in response.body()!!.result){
                        questionList.add(item)
                    }
                    setList()
                }
            }

            override fun onFailure(call: Call<GetResponse<QuestionResponse>>, t: Throwable) {
                onErrorEvent.call()
                setIsLoadingFalse()
            }

        })
    }

    fun goWriteQuestion(){
        goWriteQuestionEvent.call()
    }
}