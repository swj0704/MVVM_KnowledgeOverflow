package com.example.knowledgeoverflow.viewmodel.activity

import com.example.knowledgeoverflow.base.BaseViewModel
import com.example.knowledgeoverflow.network.api.AddAPI
import com.example.knowledgeoverflow.network.api.CheckAPI
import com.example.knowledgeoverflow.network.api.GetAPI

class WriteQuestionViewModel(val getAPI: GetAPI, val addAPI: AddAPI, val checkAPI: CheckAPI) : BaseViewModel() {
}