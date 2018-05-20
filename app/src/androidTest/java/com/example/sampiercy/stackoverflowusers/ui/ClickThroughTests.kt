package com.example.sampiercy.stackoverflowusers.ui

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.sampiercy.stackoverflowusers.R
import com.example.sampiercy.stackoverflowusers.atPosition
import com.example.sampiercy.stackoverflowusers.getText
import org.hamcrest.CoreMatchers.endsWith
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class ClickThroughTests {


    @Rule
    @JvmField
    val landingActivity = ActivityTestRule<HomePageActivity>(HomePageActivity::class.java, true, true)

    @Test
    fun givenIHaveMockData_whenIClickFirstUserItem_thenShowCorrectDisplayName() {
        scrollAndClick(0)
        Log.d("Sam", onView(withId(R.id.name)).getText())
        onView(withId(R.id.name)).check(matches(withText(endsWith("Jon Skeet"))))
    }

    @Test
    fun givenIHaveMockData_whenIClickNinthUserItem_thenShowCorrectReputation() {
        scrollAndClick(8)
        onView(withId(R.id.reputation)).check(matches(withText(endsWith("644137"))))
    }

    @Test
    fun givenIHaveMockData_whenIClickThroughRandomItem_thenTheNameStaysConsistent() {
        val randomCell = Random().nextInt(9)
        scrollAndClick(randomCell)
        val temp = onView(withId(R.id.name)).getText()
        Espresso.pressBack()
        scrollTo(randomCell)
        onView(withId(R.id.recyclerView))
                .check(matches(atPosition(randomCell, hasDescendant(withText(temp)))));
    }


    fun scrollTo(cell: Int) {
        onView(withId(R.id.recyclerView)).perform(scrollToPosition<RecyclerView.ViewHolder>(cell))
    }

    fun scrollAndClick(cell: Int) {
        scrollTo(cell)
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(cell, ViewActions.click()))
    }


}