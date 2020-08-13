package com.example.devshunter.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(
    val name: String,
    val email: String,
    val adress: String,
    val contact: String,
    val job: String
): Parcelable