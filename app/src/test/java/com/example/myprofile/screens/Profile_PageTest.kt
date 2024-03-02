package com.example.myprofile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myprofile.R
import com.example.myprofile.objects.JUnitUtil.validate_profileInfo
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



class Profile_PageTest{


    @Test
    fun  ` if name is Empty `(){
        var result = validate_profileInfo("", "Android Developer with 3+years")
        Assert.assertFalse(result)
    }


    @Test
    fun  ` if Description is Empty `(){
        var result = validate_profileInfo("Praveen", "")
        Assert.assertFalse(result)
    }


    @Test
    fun  ` name Minimal Length `(){
        var result = validate_profileInfo("Pr", "Android Developer with 3+years")
        Assert.assertFalse(result)
    }


    @Test
    fun  ` Description Minimal Length `(){
        var result = validate_profileInfo("Praveen", "An")
        Assert.assertFalse(result)
    }






}