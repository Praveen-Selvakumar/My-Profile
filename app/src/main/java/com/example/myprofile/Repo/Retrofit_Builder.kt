package com.example.myprofile.Repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit_Builder(){

    public fun  api(BASE_URL: String) =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)

}