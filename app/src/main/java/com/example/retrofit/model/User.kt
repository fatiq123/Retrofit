package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class User(
    val userId: Int,
    val it: Int,
    val title: String,
    @SerializedName("body")
    val text: String
)
