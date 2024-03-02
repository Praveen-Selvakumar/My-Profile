package com.example.myprofile.Repo

import com.example.myprofile.adapter.MarvelModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("marvel")
    fun getHerosList(): Call<List<MarvelModel>>


}