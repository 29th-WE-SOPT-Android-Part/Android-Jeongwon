package com.example.androidassignment.data

import com.google.gson.annotations.SerializedName

data class RequestSignInData(
    @SerializedName("email")
    val id : String,
    val password : String
)
