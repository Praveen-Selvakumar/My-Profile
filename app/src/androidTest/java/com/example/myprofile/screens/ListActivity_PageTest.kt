package com.example.myprofile.screens

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.myprofile.R
import com.example.myprofile.adapter.MarvelListAdapter
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListActivity_PageTest{


    @Rule
    @JvmField
    public val activityRule = ActivityTestRule(ListActivity_Page::class.java);

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(ListActivity_Page::class.java)


    @Test
    public fun checkRecyclerView(){
         onView(withId(R.id.rv))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rv))
            .perform(RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(1));

        onView(withId(R.id.rv))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()));


        var recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rv)
        var itemCount = recyclerView.adapter?.itemCount

        if (itemCount !=  null){

            //Scroll RecyclerView and drag that position
            onView(withId(R.id.rv))
                 .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))

            //Drag to that particular position
            onView(withId(R.id.rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        }


    }

    @Test
    public fun  checkCardName(){
        var recyclerView : RecyclerView = activityRule.activity.findViewById(R.id.rv)
        var itemCount = recyclerView.adapter?.itemCount

         if (itemCount !=  null){

            //Drag to that particular position
            onView(withId(R.id.rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition<MarvelListAdapter.ViewHolder>(2, click()))

            onView(withId(R.id.name))
                .check(matches(not(isDisplayed())))
        }

    }



}
