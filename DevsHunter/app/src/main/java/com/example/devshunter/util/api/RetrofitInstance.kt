package com.example.devshunter.util.api

import android.content.Context
import com.example.devshunter.util.sharedpreference.SharedPrefUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private const val TOKEN_KEY = "0000"


    private val headerInterceptor  = Interceptor { chain ->
        val pref = SharedPrefUtils(null)
        val token = pref.getStringPref(TOKEN_KEY)
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

    val engineerApi: EngineerApi by lazy {
        retrofit.create(EngineerApi::class.java)
    }

    val userApi: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    val projectApi: ProjectApi by lazy {
        retrofit.create(ProjectApi::class.java)
    }

    val recruiterApi: RecruiterApi by lazy {
        retrofit.create(RecruiterApi::class.java)
    }
}
