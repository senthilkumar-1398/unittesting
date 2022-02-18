package com.example.unittest11_08_2021.register

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RegisterFieldValidationsTest {
    lateinit var userValidation: RegisterFieldValidations

    @Before
    fun setUp() {
        userValidation = RegisterFieldValidations()
    }

    @Test
    fun validInputCheck() {
        Assert.assertTrue(
            userValidation.validation(
                "Johan",
                "jhon",
                "1234567",
                "test1234@gmail.com",
                "1234",
                "1234",
                true
            )
        )
    }

    @Test
    fun firstNameEmptyCheck() {
        Assert.assertFalse(
            userValidation.validation(
                "",
                "jhon",
                "1234567",
                "test1234@gmail.com",
                "1234",
                "1234",
                true
            )
        )
    }

    @Test
    fun lastNameEmptyCheck() {
        Assert.assertFalse(
            userValidation.validation(
                "Johan",
                "",
                "1234567",
                "test1234@gmail.com",
                "1234",
                "1234",
                true
            )
        )
    }

    @Test
    fun mobileNoSizeCheck() {
        Assert.assertFalse(
            userValidation.validation(
                "Johan",
                "",
                "1234",
                "test1234@gmail.com",
                "1234",
                "1234",
                true
            )
        )
    }

    @Test
    fun existingValueTesting() {
        Assert.assertFalse(
            userValidation.validation(
                "Johan",
                "",
                "1234",
                "test123@gmail.com",
                "1234",
                "1234",
                true
            )
        )
    }

    @Test
    fun termsCheck() {
        Assert.assertFalse(
            userValidation.validation(
                "Johan",
                "Jhon",
                "98761234",
                "test1234@gmail.com",
                "1234",
                "1234",
                false
            )
        )
    }

    @Test
    fun correctEmailFormatTest() {
        Assert.assertTrue(
            userValidation.eMailValidation("test123@gmail.com")
        )
    }

    @Test
    fun emailWithoutDomainName() {
        Assert.assertFalse(
            userValidation.eMailValidation("test123@gmail")
        )
    }

    @Test
    fun emailIncorrectFormat() {
        Assert.assertFalse(
            userValidation.eMailValidation("test123gmail.com")
        )
    }

    @Test
    fun emailWithoutDot() {
        Assert.assertFalse(
            userValidation.eMailValidation("test123@gmailcom")
        )
    }

}