package com.example.engineerapp.register

data class RegisterModel(
    val created_at: String,
    val phone: String,
    val user_email: String,
    val user_name: String,
    val user_role: Int,
    val user_status: Int
)