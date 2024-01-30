package com.example.t10a1_lagardera_carles

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCharacters(@Url url:String): Response<List<HogwartsResponse>>

}