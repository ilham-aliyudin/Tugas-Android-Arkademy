package com.example.engineerapp.dashboard.profile

data class EngineerByIdResponse(
        val `data`: List<EngineerByIdModel>,
        val status: Boolean
)