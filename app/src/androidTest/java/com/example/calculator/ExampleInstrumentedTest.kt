package com.example.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
     * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentatedTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addResult() {
        onView(withText("2")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("9")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("9")))
        onView(withText("=")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("11")))
    }

    @Test
    fun subtractResult() {
        onView(withText("2")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("-")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("-")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("2")))
        onView(withText("9")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("9")))
        onView(withText("=")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("-7")))
    }

    @Test
    fun overwriteOperation() {
        onView(withText("4")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("-")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("9")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("9")))
        onView(withText("=")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("13")))
    }

    @Test
    fun multiOperation() {
        onView(withText("4")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("-")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("9")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("9")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("-5")))
        onView(withText("5")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("5")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("0")))
    }

    @Test
    fun minusNothing() {
        onView(withText("4")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("-")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("=")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("+")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("4")))
        onView(withText("5")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("5")))
        onView(withText("=")).perform(click())
        onView(withId(R.id.result)).check(matches(withText("9")))
    }
}