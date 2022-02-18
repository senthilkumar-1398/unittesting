package com.example.unittest11_08_2021.simplevalidationtest

import org.junit.Assert
import org.junit.Test

class UserValidationTest {
    private val userValidation: UserValidation = UserValidation()

    @Test
    fun validInputCheck() {
        Assert.assertTrue(
            userValidation.validation("Johan", "123", "123")
        )
    }

    @Test
    fun userNameEmptyCheck() {
        Assert.assertFalse(
            userValidation.validation("", "123", "123")
        )
    }

    @Test
    fun passwordEmptyCheck() {
        Assert.assertFalse(
            userValidation.validation("Johan", "", "123")
        )
    }

    @Test
    fun existingNameCheck() {
        Assert.assertFalse(
            userValidation.validation("Jhon", "123", "123")
        )
    }

    @Test
    fun passwordSizeCheck() {
        Assert.assertFalse(
            userValidation.validation("Johan", "12", "123")
        )
    }

    @Test
    fun mismatchPasswordSizeCheck() {
        Assert.assertFalse(
            userValidation.validation("Johan", "1234", "123")
        )
    }

    @Test
    fun emailValidation() {
        Assert.assertTrue(
            userValidation.eMailValidation("senthils1398@gmail.com")
        )
    }

    @Test
    fun emailValidation2() {
        Assert.assertFalse(
            userValidation.eMailValidation("senthils1398@")
        )
    }

    @Test
    fun emailValidation3() {
        Assert.assertFalse(
            userValidation.eMailValidation("senthils1398")
        )
    }


}