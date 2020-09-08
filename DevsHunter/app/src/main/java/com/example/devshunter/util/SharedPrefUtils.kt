package com.example.devshunter.util

import android.content.Context
import android.content.SharedPreferences

class SharedPrefUtils {

    fun savePref(context: Context, key: String, value: String) {
        val pref: SharedPreferences = context.getSharedPreferences(key, value)
    }
}