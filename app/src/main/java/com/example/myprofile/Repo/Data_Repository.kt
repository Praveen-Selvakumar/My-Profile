package com.example.myprofile.Repo

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.myprofile.adapter.MarvelListAdapter
import com.example.myprofile.adapter.MarvelModel
import retrofit2.Call
import retrofit2.Response

object Data_Repository {

    public  val BASE_URL = "https://simplifiedcoding.net/demos/"


    fun  getData(mutableLiveData: MutableLiveData<ArrayList<MarvelModel>>): MutableLiveData<ArrayList<MarvelModel>>{
         Retrofit_Builder().api(BASE_URL).getHerosList().enqueue(object :
            retrofit2.Callback<List<MarvelModel>> {
            override fun onResponse(
                call: Call<List<MarvelModel>>,
                response: Response<List<MarvelModel>>
            ) {
                if (response.isSuccessful){
                    Log.d("RETRO_RESPONSE", "onResponse: ${response.body()}")
                    mutableLiveData.value = response.body() as ArrayList
                }else{
                    Log.d("RETRO_RESPONSE", "Response not successfull: ${response.body()}")
                }

            }

            override fun onFailure(call: Call<List<MarvelModel>>, t: Throwable) {
                Log.d("RETRO_RESPONSE", "Response have exception: ${t.cause}")

            }

        })

        return  mutableLiveData;
    }

}