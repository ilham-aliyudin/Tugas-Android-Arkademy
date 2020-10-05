package com.example.devshunter.api

import com.example.devshunter.models.EngineerResponse
import retrofit2.Response
import retrofit2.http.GET

interface EngineerApi {

    @GET("engineers")
    suspend fun getAllEngineers(): Response<Array<EngineerResponse>>
}