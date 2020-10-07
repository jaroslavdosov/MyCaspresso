package com.example.mycaspresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mycaspresso.screen.SimpleScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.android.allureScreenshot
import io.qameta.allure.android.rules.LogcatRule
import io.qameta.allure.android.rules.ScreenshotRule
import io.qameta.allure.android.rules.WindowHierarchyRule
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
class ExampleInstrumentedCaspressoTest: TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val screenRule = ScreenshotRule(mode = ScreenshotRule.Mode.FAILURE, screenshotName = "ss_end")

    @get:Rule
    val logcatRule = LogcatRule()

    @get:Rule
    val windowHierarchyRule = WindowHierarchyRule()

    @Test
    fun test() {
        before {
           println("before")
        }.after {
        }.run {

            SimpleScreen.checkWelcomePage()
            SimpleScreen.checkSwith(false)

            SimpleScreen.clickOnSwith()
            SimpleScreen.checkSwith(true)

            SimpleScreen.clickOnSwith()
            SimpleScreen.checkSwith(false)
        }
    }

    @Test
    fun testf() {
        before {
            println("before")
        }.after {
        }.run {

            SimpleScreen.checkWelcomePage()
            SimpleScreen.checkSwith(true)

            SimpleScreen.clickOnSwith()
            SimpleScreen.checkSwith(true)

            SimpleScreen.clickOnSwith()
            SimpleScreen.checkSwith(true)
        }
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