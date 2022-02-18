package com.example.unittest11_08_2021.datastoretest

import android.content.Context
import androidx.datastore.preferences.preferencesKey
import androidx.lifecycle.asLiveData
import androidx.lifecycle.observe
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.system.measureTimeMillis

@ExperimentalCoroutinesApi
class DataStoreManagerTest {
    lateinit var mDataStoreManager: DataStoreManager
    val KEY_NAME = preferencesKey<String>("name")
    var getString: String? = null
    lateinit var context:Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext<Context>()
        mDataStoreManager = DataStoreManager(context)
    }

    @Test
    fun saveTest() = runBlocking {
        mDataStoreManager.storeValue(KEY_NAME, "senthil123")
    }

    @Test
    fun getValue() = runBlocking {
        mDataStoreManager.userNameFlow.asLiveData().observeForever{
            Assert.assertEquals("senthil12", it)
        }
    }

//    @Test
//    fun deleteData() = runBlocking {
//        mDataStoreManager.removeSingleData(KEY_NAME)
//    }


    @After
    fun tearDown() {
    }
}