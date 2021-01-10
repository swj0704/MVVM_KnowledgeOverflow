package com.example.knowledgeoverflow.network.api

import com.example.knowledgeoverflow.network.DTO.CheckQuestion
import com.example.knowledgeoverflow.network.DTO.GetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CheckAPI {
    @GET("api/check_similar_question")
    fun checkQuestion(
        @Query("text") text : String
    ) : Call<GetResponse<CheckQuestion>>


    @GET("api/check_swearing")
    fun checkSwearing(
        @Query("text") text : String
    ) : Call<GetResponse<String>>
}