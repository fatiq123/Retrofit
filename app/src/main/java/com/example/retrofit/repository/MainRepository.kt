package com.example.retrofit.repository

import com.example.retrofit.model.User
import com.example.retrofit.retrofit.JsonPlaceHolderApi
import com.example.retrofit.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {

    val jsonPlaceHolderApi: JsonPlaceHolderApi = RetrofitInstance()
        .retrofitInstance()
        .create(JsonPlaceHolderApi::class.java)


    suspend fun getUserApi(): List<User> {
        return withContext(Dispatchers.IO) {
            val response = jsonPlaceHolderApi.getPosts()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        }
    }

}