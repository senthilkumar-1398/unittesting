package com.example.unittest11_08_2021.register

import java.util.regex.Pattern

class RegisterFieldValidations {
    private val existingEmail = listOf("test123@gmail.com")

    fun validation(
        firstName: String,
        lastName: String,
        mobileNo: String,
        emailId: String,
        password: String,
        confirmPassword: String,
        terms: Boolean
    ): Boolean {
        if (firstName.isEmpty() || lastName.isEmpty() || mobileNo.isEmpty() || emailId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return false
        } else if (mobileNo.length < 6) {
            return false
        } else if (password.length < 3) {
            return false
        } else if (password != confirmPassword) {
            return false
        } else if (!terms) {
            return false
        } else if (emailId in existingEmail) {
            return false
        }
        return true
    }

    fun eMailValidation(emailString: String?): Boolean {
        val EMAIL_PATTERN: Pattern =
            Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+")
        return if (null == emailString || emailString.isEmpty()) {
            false
        } else EMAIL_PATTERN.matcher(emailString).matches()
    }

}