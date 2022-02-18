package com.example.unittest11_08_2021.datastoretest

import android.app.Activity
import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(context: Context) {

    //Create the dataStore
    val mDataStore = context.createDataStore(name = "user_details")
    val KEY_NAME = preferencesKey<String>("name")


    suspend inline fun <reified T> storeValue(key: Preferences.Key<T>, value: Any) {
        mDataStore.edit {
            it[key] = value as T
        }
    }

    suspend inline fun removeData(activity: Activity) {
        mDataStore.edit {
            it.clear()
        }
    }

    suspend inline fun removeSingleData(key: Preferences.Key<String>) {
        mDataStore.edit {
            it.remove(key)

        }
    }

    // Create a name flow to retrieve name from the preferences
    val userNameFlow: Flow<String> = mDataStore.data.map {
        it[KEY_NAME]!!
    }

    suspend inline fun <reified T> readValue(
        key: Preferences.Key<T>,
        crossinline responseFunc: T.() -> Unit
    ) {
        mDataStore.getFromLocalStorage(key) {
            responseFunc.invoke(this)
        }
    }

    suspend inline fun <reified T> DataStore<Preferences>.getFromLocalStorage(
        PreferencesKey: Preferences.Key<T>, crossinline func: T.() -> Unit
    ) {
        data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[PreferencesKey]
        }.collect {
            it?.let {
                func.invoke(it as T)
            }
        }
    }
}