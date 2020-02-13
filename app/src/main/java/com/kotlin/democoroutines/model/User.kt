package com.kotlin.democoroutines.model

import android.text.TextUtils
import android.util.Patterns

class User(override val email: String, override val pass: String) : IUser {
    override fun isDataValid(): Int {
        when {
            TextUtils.isEmpty(email) -> return 0
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> return 1
            pass.length < 6 -> return 2
            else -> return -1
        }
    }
}