package com.example.knowledgeoverflow.network.DTO

data class QuestionVote(
    val question_id : Int,
    val owner_id : Int,
    val type : Int
)