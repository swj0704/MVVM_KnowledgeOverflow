package com.example.knowledgeoverflow.network.DTO

data class AnswerResponse(
    val id : Int,
    val question_id : Int,
    val owner_id : Int,
    val text : String,
    val upload_time : String
)