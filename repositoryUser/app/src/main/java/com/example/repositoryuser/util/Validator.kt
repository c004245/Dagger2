package com.example.repositoryuser.util

import android.text.TextUtils

class Validator {

    fun validUsername(username: String) : Boolean {
        return !TextUtils.isEmpty(username)
    }
}