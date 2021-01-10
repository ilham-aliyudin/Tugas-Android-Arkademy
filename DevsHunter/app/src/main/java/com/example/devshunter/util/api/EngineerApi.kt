package com.example.devshunter.util.api

import com.example.devshunter.models.EngineerResponse
import retrofit2.Response
import retrofit2.http.GET

interface EngineerApi {

    @GET("engineers")
    suspend fun getAllEngineers(): Response<ArrayList<EngineerResponse>>
}