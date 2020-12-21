package com.example.knowledgeoverflow.DTO

data class GetResponse<T>(
    val status : Int,
    val result : ArrayList<T>
)