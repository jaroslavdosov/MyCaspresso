package com.example.mycaspresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.qameta.allure.android.runners.AllureAndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AllureAndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.mycaspresso", appContext.packageName)
    }

    @Test fun swithTap() {

        Espresso.onView(ViewMatchers.withText("Hello World!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.switch1))
            .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
        Espresso.onView(withId(R.id.switch1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.switch1))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.switch1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.switch1))
            .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))

        Espresso.onView(ViewMatchers.withText("Hello World!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}