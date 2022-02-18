package com.example.unittest11_08_2021.sharedpref

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SharedPreferenceEditorTest {
    lateinit var mSharedPreferenceEditor: SharedPreferenceEditor
    private var mSaveString = "test"
    private var KEY_PREF = "test_key"

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mSharedPreferenceEditor = SharedPreferenceEditor(context)
    }

    @Test
    fun saveTest() {
        //step1 - Save data
        mSharedPreferenceEditor.saveData(KEY_PREF, mSaveString)

        //step2 - Retrieve data
        val mGetString = mSharedPreferenceEditor.getData(KEY_PREF)
        //step3 - Check string match
        Assert.assertEquals(mSaveString, mGetString)

        //step3 - Delete data
        mSharedPreferenceEditor.removeData(KEY_PREF)
        val mGetString2 = mSharedPreferenceEditor.getData(KEY_PREF)
        Assert.assertEquals("", mGetString2)
    }

    @After
    fun tearDown() {
        mSharedPreferenceEditor.saveData(KEY_PREF, null)
    }
}