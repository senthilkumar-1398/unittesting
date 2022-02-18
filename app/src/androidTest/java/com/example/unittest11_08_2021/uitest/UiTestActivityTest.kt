package com.example.unittest11_08_2021.uitest

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.unittest11_08_2021.R
import org.junit.After
import org.junit.Before

import org.junit.Test

class UiTestActivityTest {
    private lateinit var activityScenario: ActivityScenario<UiTestActivity>
    private val mName = "Johnn Michael"
    private val mEmail = "Test@gmail.com"
    private val mAddress = "Coimbatore,Tamilnadu"

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(UiTestActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testUserInputScenario() {
        // perform type name field
        Espresso.onView(withId(R.id.edittext_name)).perform(ViewActions.typeText(mName))

        // perform type email field
        Espresso.onView(withId(R.id.edittext_mail)).perform(ViewActions.typeText(mEmail))

        // perform type email field
        Espresso.onView(withId(R.id.edittext_address)).perform(ViewActions.typeText(mAddress))

        // perform close keyboard
        Espresso.closeSoftKeyboard()

        // perform button click
        Espresso.onView(withId(R.id.btn_submit)).perform(ViewActions.click())

        // checking the text in the textview
        Espresso.onView(withId(R.id.tv_name)).check(ViewAssertions.matches(withText(mName)))
        Espresso.onView(withId(R.id.tv_email)).check(ViewAssertions.matches(withText(mEmail)))
        Espresso.onView(withId(R.id.tv_address)).check(ViewAssertions.matches(withText(mAddress)))

    }

    @After
    fun tearDown() {
        activityScenario.moveToState(Lifecycle.State.RESUMED)
    }
}