package com.example.devshunter.repository

import com.example.devshunter.util.api.RetrofitInstance
import com.example.devshunter.models.EngineerResponse
import retrofit2.Response

class EngineerRepository {

    suspend fun getAllEngineers(): Response<ArrayList<EngineerResponse>> {
        return RetrofitInstance.engineerApi.getAllEngineers()
    }
}