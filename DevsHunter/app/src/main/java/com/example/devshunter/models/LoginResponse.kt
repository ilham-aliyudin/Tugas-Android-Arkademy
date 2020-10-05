package com.example.devshunter.models

data class LoginResponse(val status: String, val message: LoginData) {
    data class LoginData(
        val id: Int?,
        val user_name: String?,
        val user_password: String?,
        val user_email: String?,
        val user_role: Int?,
        val user_status: Int?,
        val token: String?
    )
}