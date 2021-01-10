package com.example.devshunter.repository

import com.example.devshunter.util.api.RetrofitInstance
import com.example.devshunter.models.RecruiterByIdResponse
import com.example.devshunter.models.RecruiterResponse
import retrofit2.Response

class RecruiterRepository {

    suspend fun createRecruiter(
        idUser: Int?,
        nama: String?,
        lokasi: String?,
        bidang: String?,
        deskripsi: String?,
        kontak: Int?,
        jabatan: String?,
        linkedIn: String?
    ): Response<RecruiterResponse> {
        return RetrofitInstance.recruiterApi.createRecruiter(
            idUser, nama, lokasi, bidang, deskripsi, kontak, jabatan, linkedIn
        )
    }

    suspend fun getRecruiterById(id: Int?): Response<RecruiterByIdResponse> {
        return RetrofitInstance.recruiterApi.getRecruiterById(id)
    }

    suspend fun updateRecruiterById(id: Int?): Response<RecruiterByIdResponse> {
        return RetrofitInstance.recruiterApi.updateRecruiterById(id)
    }
}