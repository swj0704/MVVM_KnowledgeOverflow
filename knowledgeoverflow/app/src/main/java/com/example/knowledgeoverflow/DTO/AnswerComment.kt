package com.example.knowledgeoverflow.DTO

data class AnswerComment(
    val id : Int,
    val answer_id : Int,
    val owner_id : Int,
    val text : String,
    val upload_time : String
)