package com.example.engineerapp.dashboard.offer

data class OfferResponse(
    val `data`: List<OfferModel>,
    val status: Boolean
)