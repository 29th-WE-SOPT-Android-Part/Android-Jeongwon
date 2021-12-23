package com.example.androidassignment.data

data class ResponseSignUpData(
    val responseData: ResponseData,
    val data : Data
) {
    data class Data(
        val id : Int,
        val name : String,
        val email : String
    )
}
