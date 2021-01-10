package com.example.engineerapp.utils.services

import com.example.engineerapp.login.LoginResponse
import com.example.engineerapp.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("register")
    suspend fun registerUser(
        @Field("user_name") userName: String?,
        @Field("user_email") userEmail: String?,
        @Field("phone") phone: String,
        @Field("user_password") userPassword: String,
        @Field("user_role") userRole: Int?,
        @Field("user_status") userStatus: Int?,
        @Field("created_at") userCreated: String?
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("user_email") email: String?,
        @Field("user_password") password: String?
    ): Response<LoginResponse>
}