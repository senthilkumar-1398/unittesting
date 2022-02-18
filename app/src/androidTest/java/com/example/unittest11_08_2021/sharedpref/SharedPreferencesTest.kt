package com.example.unittest11_08_2021.sharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.test.InstrumentationRegistry
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class
SharedPreferencesTest {
    private val PREFS_NAME = "prefs"
    private val KEY_PREF = "KEY_PREF"
    private var sharedPreferences: SharedPreferences? = null

    @Before
    fun before() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    @Test
    @Throws(Exception::class)
    fun put_and_get_preference() {
        val string1 = "test"
        sharedPreferences!!.edit().putString(KEY_PREF, string1).apply()
        val string2 = sharedPreferences!!.getString(KEY_PREF, "")

        // Verify that the received data is correct.
        Assert.assertEquals(string1, string2)
    }

    @After
    fun after() {
        sharedPreferences!!.edit().putString(KEY_PREF, null).apply()
    }
}