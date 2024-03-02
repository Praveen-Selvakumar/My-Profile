package com.example.myprofile.Repo

import android.view.Display.Mode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myprofile.adapter.MarvelModel

class MainViewModel : ViewModel() {


    private  val  TAG = "Main_ViewModel"
    private var mutableLiveData =   MutableLiveData<ArrayList<MarvelModel>>();


    public fun getMutableLiveData():   MutableLiveData<ArrayList<MarvelModel>>{
        return  Data_Repository.getData(mutableLiveData);
    }


}