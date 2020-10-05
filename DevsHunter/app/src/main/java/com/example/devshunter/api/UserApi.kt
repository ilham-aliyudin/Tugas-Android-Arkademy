package com.example.devshunter.api

import com.example.devshunter.models.LoginResponse
import com.example.devshunter.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginRequest(
        @Field("user_email") email: String?,
        @Field("user_password") password: String?
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    suspend fun registerRequest(
        @Field("user_name") userName: String?,
        @Field("user_email") userEmail: String?,
        @Field("user_password") userPassword: String,
        @Field("user_role") userRole: Int?,
        @Field("user_status") userStatus: Int?,
        @Field("created_at") userCreated: String?
    ): RegisterResponse
}