package com.example.devshunter.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EngineerModel(
    val nama: String?,
    val jobdesc: String?,
    val lokasi: String?,
    val status: String?,
    val deskripsi: String?,
    val skill: String?
): Parcelable