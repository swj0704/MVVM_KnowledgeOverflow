package com.example.knowledgeoverflow.network.DTO

data class GetResponse<T>(
    val status : Int,
    val result : ArrayList<T>
)