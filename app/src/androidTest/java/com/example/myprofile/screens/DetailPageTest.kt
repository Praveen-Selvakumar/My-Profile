package com.example.myprofile.screens

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myprofile.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.Description
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailPageTest{



    @get:Rule
    public  val activityScenarioRule = activityScenarioRule<DetailPage>()

    @Test
    fun  nameHaveText(){
        onView(withId(R.id.team))
            .check(matches(withText("Avengers")))
            .check(matches(isDisplayed()))
    }




    @Test
    fun isBackButtonValid(){
        onView(withId(R.id.back_btn))
            .check(matches(isDisplayed()))
            .perform(click())
   }



    @Test
    fun isProfileImgDisplayed(){
        onView(withId(R.id.profile_img))
            .check(matches(isDisplayed()))
   }



    @Test
    fun isContentAvailable(){
         onView(withId(R.id.name))
            .check(matches(isDisplayed()))
             .check(matches(not("")))

        onView(withId(R.id.realname))
            .check(matches(isDisplayed()))
            .check(matches(not("")))

        onView(withId(R.id.publisher))
            .check(matches(isDisplayed()))
            .check(matches(not("")))

        onView(withId(R.id.cnt_txt))
            .check(matches(isDisplayed()))
            .check(matches(not("")))


        onView(withId(R.id.createdby))
            .check(matches(isDisplayed()))
            .check(matches(not("")))
     }



}
