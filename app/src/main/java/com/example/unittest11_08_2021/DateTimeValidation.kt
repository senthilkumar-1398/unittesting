package com.example.unittest11_08_2021

import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat

class DateTimeValidation {
    private val mParser = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")

    fun getDateTimeFromString(mDateTime: String?): String? {
        val mSimpleDateFormat = SimpleDateFormat("dd MMM, hh:mm a")

        return mSimpleDateFormat.format(mParser.parse(mDateTime))
    }

    fun getDateFromString(mDateTime: String?): String? {
        val mSimpleDateFormat = SimpleDateFormat("MMMM dd")

        return mSimpleDateFormat.format(mParser.parse(mDateTime))
    }

    fun getTimeFromString(mDateTime: String?): String? {
        val mSimpleDateFormat = SimpleDateFormat("hh:mm a")

        return mSimpleDateFormat.format(mParser.parse(mDateTime))
    }

    fun getDateString(mDateTime: String?): String? {
        val mSimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")

        return mSimpleDateFormat.format(mParser.parse(mDateTime))
    }
}