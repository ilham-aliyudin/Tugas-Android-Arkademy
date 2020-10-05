package com.example.devshunter.repository

import com.example.devshunter.api.RetrofitInstance
import com.example.devshunter.models.EngineerResponse
import retrofit2.Response

class EngineerRepository {

    suspend fun getAllEngineers(): Response<Array<EngineerResponse>> {
        return RetrofitInstance.engineerApi.getAllEngineers()
    }
}