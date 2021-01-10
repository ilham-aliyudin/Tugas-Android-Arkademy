package com.example.engineerapp.dashboard.offer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfferModel(
    val confirm_status: String,
    val deadline: String,
    val description: String,
    val nama: String,
    val price: Int,
    val project_name: String
): Parcelable