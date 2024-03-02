package com.example.myprofile.screens

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myprofile.MainActivity
import com.example.myprofile.R
import com.example.myprofile.objects.Constants
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito


class ListActivity_PageTest{


    @Test
    fun isListOccupied(){
        val getData = Constants.passEmptyList()
        assertFalse(getData.isEmpty())
    }

    val sharedPreferences = Mockito.mock(SharedPreferences::class.java)
    val editor = Mockito.mock(SharedPreferences.Editor::class.java)




    @Test
    fun ` validate user name `(){
        editor.putString("name","Praveen Selvakumar");
        editor.commit()
        var name = sharedPreferences.getString("name","");
        assertFalse(name!!.isEmpty())
    }


    @Test
    fun ` validate user description `(){
        editor.putString("des","Android Developer with 3+ years Experience");
        editor.commit()
        var name = sharedPreferences.getString("des","");
        assertFalse(name!!.isEmpty())
    }


}