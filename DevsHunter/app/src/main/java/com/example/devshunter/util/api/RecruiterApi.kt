package com.example.devshunter.util.api

import com.example.devshunter.models.RecruiterByIdResponse
import com.example.devshunter.models.RecruiterResponse
import retrofit2.Response
import retrofit2.http.*

interface RecruiterApi {

    @FormUrlEncoded
    @POST("recruiter")
    suspend fun createRecruiter(
        @Field("id_user") idUser: Int?,
        @Field("nama") nama: String?,
        @Field("lokasi") bidang: String?,
        @Field("bidang") lokasi: String?,
        @Field("deskripsi") deskripsi: String?,
        @Field("kontak") kontak: Int?,
        @Field("jabatan") jabatan: String?,
        @Field("linked_in") linkedIn: String?
    ): Response<RecruiterResponse>

    @GET("recruiter/{id}")
    suspend fun getRecruiterById(
        @Path("id") id: Int?
    ): Response<RecruiterByIdResponse>

    @PUT("recruiter/{id}")
    suspend fun updateRecruiterById(
        @Path("id") id: Int?
    ): Response<RecruiterByIdResponse>
}