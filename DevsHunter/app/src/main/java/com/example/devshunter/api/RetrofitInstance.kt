package com.example.devshunter.api

import com.example.devshunter.models.RegisterResponse
import com.example.devshunter.util.SharedPrefUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private const val TOKEN_KEY = "0000"

    private val headerInterceptor  = Interceptor { chain ->
        val pref = SharedPrefUtils(context = null)
        val token = pref.getStringPref(TOKEN_KEY)
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        chain.proceed(request)
    }

    private val client = OkHttpClient.Builder().run {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(20, TimeUnit.SECONDS)
        writeTimeout(25, TimeUnit.HOURS)
        addInterceptor(headerInterceptor)
        retryOnConnectionFailure(true)
        build()
    }

    private val retrofit by lazy {
        Retrofit.Builder().run {
            client(client)
            baseUrl("http://54.90.231.178:8888/hire/")
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
}
