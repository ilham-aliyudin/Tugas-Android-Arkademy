package com.example.devshunter.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RecruiterByIdResponse(val result: List<RecruiterByIdData>) {
    @Parcelize
    data class RecruiterByIdData(
        @SerializedName("id") val id: Int?,
        @SerializedName("id_user") val idUser: Int?,
        @SerializedName("user_name") val userName: String?,
        @SerializedName("user_email") val userEmail: String?,
        @SerializedName("nama") val nama: String?,
        @SerializedName("bidang") val bidang: String?,
        @SerializedName("lokasi") val lokasi: String?,
        @SerializedName("deskripsi") val deskripsi: String?,
        @SerializedName("kontak") val kontak: Int?,
        @SerializedName("jabatan") val jabatan: String?,
        @SerializedName("linked_in") val linkeIn: String?,
    ): Parcelable
}