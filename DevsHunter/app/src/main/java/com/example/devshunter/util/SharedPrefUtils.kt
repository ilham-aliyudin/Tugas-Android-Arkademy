package com.example.devshunter.util

import android.content.Context
import android.content.SharedPreferences

class SharedPrefUtils(context: Context?) {
    private val prefKey = "0000"
    private val pref: SharedPreferences? = context?.getSharedPreferences(prefKey, Context.MODE_PRIVATE )

    fun savePref(key: String, value: String) {
        val editor = pref?.edit()
        editor?.putString(key, value)?.apply()
    }

    fun saveBooleanPref(key: String, value: Boolean) {
        val editor = pref?.edit()
        editor?.putBoolean(key, value)
            ?.apply()
    }

    fun getStringPref(key: String): String? {
        return pref?.getString(key, null)
    }

    fun getBooleanPref(key: String): Boolean? {
        return pref?.getBoolean(key, false)
    }

    fun clearPref() {
        val editor = pref?.edit()
        editor?.apply{
            clear()
        }?.apply()
    }
}