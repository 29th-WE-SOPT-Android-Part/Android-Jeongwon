package com.example.androidassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val SignInService: SignInService = retrofit.create(com.example.androidassignment.SignInService::class.java)
    val SignUpService: SignUpService = retrofit.create(com.example.androidassignment.SignUpService::class.java)
}