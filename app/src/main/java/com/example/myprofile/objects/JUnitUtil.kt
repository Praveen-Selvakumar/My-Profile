package com.example.myprofile.objects

import android.content.Context
import com.example.myprofile.adapter.MarvelModel

object JUnitUtil {


    //Screen 1

    //Screen 2

    //Screen 3
    // Profile Page
    fun  validate_profileInfo(name: String, description: String): Boolean{
        if (!name.isEmpty() && !description.isEmpty() && name.length >= 3  ){
            return true
        }

        return false;
    }

    fun valid_profileName(name: String): Boolean{
        if (!name.isEmpty()  && name.length >= 3  )
            return true

        return false;
    }

}