package com.example.devshunter.models

import com.google.gson.annotations.SerializedName

data class RegisterResponse(val status: String, val message: String, val data: RegisterData) {
    data class RegisterData(
        @SerializedName("user_name") val userName: String?,
        @SerializedName("user_email") val userPassword: String?,
        @SerializedName("user_role")val userRole: Int?,
        @SerializedName("user_status")val userStatus: Int?,
        @SerializedName("created_at")val created: String?
    )
}