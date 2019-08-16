package com.example.architecture.utils

import android.app.Activity
import android.content.Intent

fun Intent.startActivity(originActivity: Activity) {
    originActivity.startActivity(this)
}