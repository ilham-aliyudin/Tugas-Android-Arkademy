package com.example.engineerapp.utils.api

import android.content.Context
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response


class HeaderInterceptor(val context: Context?) : Interceptor {

    private lateinit var pref: PreferenceHelper

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        pref = PreferenceHelper(context)
        val token = pref.getStringPref(Constants.TOKEN)
        proceed(
                request().newBuilder()
                        .addHeader("Authorization", "Bearer $token")
                        .build()
        )
    }
}