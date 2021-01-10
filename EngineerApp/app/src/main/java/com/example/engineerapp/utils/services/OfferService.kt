package com.example.engineerapp.utils.services

import com.example.engineerapp.dashboard.offer.OfferResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OfferService {

    @GET("hiring/{id}")
    suspend fun getHiringById(
        @Path("id") id: Int
    ): Response<OfferResponse>
}