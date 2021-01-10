package com.example.engineerapp.login

data class LoginModel(
    val id: Int,
    val phone: Long,
    val token: String,
    val user_email: String,
    val user_name: String,
    val user_password: String,
    val user_role: Int,
    val user_status: Int
)