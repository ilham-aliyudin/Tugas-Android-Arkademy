package com.example.engineerapp.utils.api

import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import com.example.engineerapp.utils.services.EngineerService
import com.example.engineerapp.utils.services.OfferService
import com.example.engineerapp.utils.services.UserService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val headerInterceptor  = Interceptor { chain ->
        val pref = PreferenceHelper(context = null)
        val token = pref.getStringPref(Constants.TOKEN)
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        chain.proceed(request)
    }

    private var logger = HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

    private val client = OkHttpClient.Builder().run {
        connectTimeout(30, TimeUnit.HOURS)
        readTimeout(20, TimeUnit.HOURS)
        writeTimeout(25, TimeUnit.HOURS)
        addInterceptor(headerInterceptor)
        addInterceptor(logger)
        retryOnConnectionFailure(true)
        build()
    }

    private val retrofit by lazy {
        Retrofit.Builder().run {
            client(client)
            baseUrl("http://10.0.2.2:8000/hire/")
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
    }

    val userService: UserService? by lazy {
        retrofit.create(UserService::class.java)
    }

    val engineerService: EngineerService? by lazy {
        retrofit.create(EngineerService::class.java)
    }

    val offerService: OfferService? by lazy {
        retrofit.create(OfferService::class.java)
    }
}