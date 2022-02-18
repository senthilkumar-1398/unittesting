package com.example.unittest11_08_2021.sharedpref

import android.content.Context
import android.content.SharedPreferences
annotation class Inject

annotation class ApplicationContext

class SharedPreferenceEditor @Inject constructor(
    @ApplicationContext
    private val mContext: Context
) {
    init {
        if (mSharedPreferences == null) {
            mSharedPreferences = mContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        }
    }
    fun saveData(key: String?, value: String?) {
        val mPreferenceEditor = mSharedPreferences?.edit()
        mPreferenceEditor?.putString(key, value)
        mPreferenceEditor?.apply()
    }
    fun getData(key: String?): String? {
        if (containData(key!!)) {
            return mSharedPreferences?.getString(key, "")
        }
        return ""
    }
    fun removeData(key: String) {
        val mPreferenceEditor = mSharedPreferences?.edit()
        if (containData(key)) {
            mPreferenceEditor?.remove(key)
            mPreferenceEditor?.apply()
        }
    }
    private fun containData(key: String): Boolean {
        return mSharedPreferences?.contains(key)!!
    }
    companion object {
        private var mSharedPreferences: SharedPreferences? = null
        const val PREFERENCES = "delivery_dispatch_preferences"
    }
}