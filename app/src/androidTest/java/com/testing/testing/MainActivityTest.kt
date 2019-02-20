package com.testing.testing


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.RootMatchers.withDecorView



@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun emptyEmailTest() {
    val appCompatButton = onView(withId(R.id.login_btn))
        appCompatButton.perform(click())

        val editText = onView(withId(R.id.email_et))
        editText.check(matches(hasErrorText("Enter your email!")))

    }


    @Test
    fun invalidEmailTest() {
        val editText = onView(withId(R.id.email_et))
        editText.perform(replaceText("dfhsdhs"))

        val appCompatButton = onView(withId(R.id.login_btn))
        appCompatButton.perform(click())

        editText.check(matches(hasErrorText("Enter valid email!")))

    }


    @Test
    fun emptyPasswordTest() {
        val editText = onView(withId(R.id.email_et))
        editText.perform(replaceText("dfhsdhs@ff"))

        val appCompatButton = onView(withId(R.id.login_btn))
        appCompatButton.perform(click())

        val editText2 = onView(withId(R.id.password_et))
        editText2.check(matches(hasErrorText("Enter your password!")))

    }


    @Test
    fun invalidPasswordTest() {
        val editText = onView(withId(R.id.email_et))
        editText.perform(replaceText("dfhsdhs@ff"))

        val editText2 = onView(withId(R.id.password_et))
        editText2.perform(replaceText("2eff"))


        val appCompatButton = onView(withId(R.id.login_btn))
        appCompatButton.perform(click())


        editText2.check(matches(hasErrorText("Enter valid password!")))

    }


    @Test
    fun successLoginTest() {
        val editText = onView(withId(R.id.email_et))
        editText.perform(replaceText("dfhsdhs@ff"))

        val editText2 = onView(withId(R.id.password_et))
        editText2.perform(replaceText("123456"))


        val appCompatButton = onView(withId(R.id.login_btn))
        appCompatButton.perform(click())

        val activity = mActivityTestRule.activity
        onView(withText("success")).inRoot(withDecorView(not(`is`(activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

}
