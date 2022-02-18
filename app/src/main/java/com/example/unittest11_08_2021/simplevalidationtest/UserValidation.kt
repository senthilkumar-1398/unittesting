package com.example.unittest11_08_2021.simplevalidationtest

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern


class UserValidation {
    private val existingUsers = listOf("Peter", "Jhon")

    fun validation(userName: String, password: String, confirmPassword: String): Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            return false
        } else if (userName in existingUsers) {
            return false
        } else if (password != confirmPassword) {
            return false
        } else if (password.length < 3) {
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