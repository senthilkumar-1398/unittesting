package com.example.unittest11_08_2021

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DateTimeValidationTest {
    var mDateTime = "2021-07-16T13:34:00.000Z"
    lateinit var dateTimeValidation: DateTimeValidation

    @Before
    fun setUp() {
        dateTimeValidation = DateTimeValidation()
    }

    // dd MMM, hh:mm a - format test
    @Test
    fun getDateTimeFromString() {
        var mConvertDate = dateTimeValidation.getDateTimeFromString(mDateTime)
        Assert.assertEquals("16 Jul, 01:34 PM", mConvertDate)
    }

    // MMMM dd - format test
    @Test
    fun getDateFromString() {
        var mConvertDate = dateTimeValidation.getDateFromString(mDateTime)
        Assert.assertEquals("July 16", mConvertDate)
    }

    // hh:mm a - format test
    @Test
    fun getTimeFromString() {
        var mConvertDate = dateTimeValidation.getTimeFromString(mDateTime)
        Assert.assertEquals("01:34 PM", mConvertDate)
    }

    // dd-MM-yyyy - format test
    @Test
    fun getDateString() {
        var mConvertDate = dateTimeValidation.getDateString(mDateTime)
        Assert.assertEquals("16-07-2021", mConvertDate)
    }

}