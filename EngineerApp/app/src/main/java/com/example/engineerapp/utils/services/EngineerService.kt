package com.example.engineerapp.utils.services

import com.example.engineerapp.dashboard.home.EngineerResponse
import com.example.engineerapp.dashboard.profile.EngineerByIdResponse
import com.example.engineerapp.dashboard.profile.PostEngineerResponse
import com.example.engineerapp.dashboard.profile.fragment.PortfolioResponse
import retrofit2.Response
import retrofit2.http.*

interface EngineerService {

    @GET("engineers")
    suspend fun getAllEngineer(): Response<EngineerResponse>

    @GET("engineer/{id}")
    suspend fun getEngineerProfile(
            @Path("id") id: Int
    ): Response<EngineerByIdResponse>

    @FormUrlEncoded
    @POST("engineer/register")
    suspend fun createEngineer(
            @Field("id_user") idUser: Int?,
            @Field("nama") name: String?,
            @Field("jobdesc") jobDesc: String?,
            @Field("lokasi") lokasi: String?,
            @Field("status") status: String?,
            @Field("deskripsi") deskripsi: String?,
            @Field("skill") skill: String?
    ): Response<PostEngineerResponse>

    @GET("portfolio/{id}")
    suspend fun getPortfolio(
        @Path("id") id: Int
    ): Response<PortfolioResponse>
}