package com.example.devshunter.util.api

import com.example.devshunter.models.ProjectResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProjectApi {

    @GET("projects")
    suspend fun getAllProject(): Response<ProjectResponse>
//    @FormUrlEncoded
//    @POST("project")
}