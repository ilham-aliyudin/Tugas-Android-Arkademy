package com.example.engineerapp.register

data class RegisterResponse(
    val `data`: RegisterModel,
    val message: String,
    val status: String
)