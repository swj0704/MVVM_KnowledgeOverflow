package com.example.knowledgeoverflow.network.DTO

import com.google.gson.annotations.SerializedName

data class CheckQuestion (
    val id : Int,
    @SerializedName("title")
    val name : String
)