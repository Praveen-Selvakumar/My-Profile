package com.example.myprofile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myprofile.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Profile_PageTest {

    @get:Rule
    public val activityScenarioRule = activityScenarioRule<Profile_Page>()


    @Test
    public fun toolbarTitle() {
        onView(withId(R.id.start_icon_tb))
            .check(matches(isDisplayed()))
            .perform(click());
    }

    @Test
    public fun validateToolbarTitle(){
        onView(withId(R.id.tb_title))
            .check(matches(isDisplayed()))
            .check(matches(withText("Profile")))
            .perform(click());
    }

    /*@Test
    //issue
    public fun checkUserInfo(){
        onView(withId(R.id.name_txt))
            .check(matches(isDisplayed()))
             .check(matches(ViewMatchers.withText("User Name")))

         onView(withId(R.id.des_txt))
            .check(matches(isDisplayed()))
             .check(matches(ViewMatchers.withText("Description")))


     } */








}