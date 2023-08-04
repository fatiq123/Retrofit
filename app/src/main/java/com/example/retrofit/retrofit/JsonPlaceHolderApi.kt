package com.example.retrofit.retrofit

import com.example.retrofit.model.UsertList
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPosts(): Response<UsertList>
}