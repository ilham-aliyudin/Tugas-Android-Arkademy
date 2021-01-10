package com.example.devshunter.repository

import com.example.devshunter.util.api.RetrofitInstance
import com.example.devshunter.models.ProjectResponse
import retrofit2.Response

class ProjectRepository {

    suspend fun getAllProject(): Response<ProjectResponse> {
        return RetrofitInstance.projectApi.getAllProject()
    }
}