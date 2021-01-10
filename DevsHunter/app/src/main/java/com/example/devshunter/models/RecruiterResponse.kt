package com.example.devshunter.models

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class RecruiterResponse(val status: String, val message: String, val data: RecruiterData) {
    data class RecruiterData (
        @SerializedName("id_user") val idUser: Int?,
        @SerializedName("nama") val nama: String?,
        @SerializedName("lokasi") val bidang: String?,
        @SerializedName("bidang") val lokasi: String?,
        @SerializedName("deskripsi") val deskripsi: String?,
        @SerializedName("kontak") val kontak: Int?,
        @SerializedName("jabatan") val jabatan: String?,
        @SerializedName("linked_in") val linkedIn: String?
    )
}