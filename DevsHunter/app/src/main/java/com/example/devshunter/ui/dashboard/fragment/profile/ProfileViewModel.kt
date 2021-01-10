package com.example.devshunter.ui.dashboard.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devshunter.models.RecruiterByIdResponse
import com.example.devshunter.models.RecruiterResponse
import com.example.devshunter.repository.RecruiterRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ProfileViewModel(val repository: RecruiterRepository) : ViewModel() {

    var postRecruiterResponse: MutableLiveData<Response<RecruiterResponse>> = MutableLiveData()
    var getRecruiterByIdResponse: MutableLiveData<Response<RecruiterByIdResponse>> = MutableLiveData()
    var updateRecruiterByIdResponse: MutableLiveData<Response<RecruiterByIdResponse>> = MutableLiveData()

    fun createRecruiter(
        idUser: Int?,
        nama: String?,
        lokasi: String?,
        bidang: String?,
        deskripsi: String?,
        kontak: Int?,
        jabatan: String?,
        linkedIn: String?
    ) {
        viewModelScope.launch {
            val response = repository.createRecruiter(
                idUser,
                nama,
                lokasi,
                bidang,
                deskripsi,
                kontak,
                jabatan,
                linkedIn
            )
            postRecruiterResponse.value = response
        }
    }

    fun getRecruiterById(id: Int?) {
        viewModelScope.launch {
            val response = repository.getRecruiterById(id)
            getRecruiterByIdResponse.value = response
        }
    }

    fun updaterRecruiterById(id: Int?) {
        viewModelScope.launch {
            val response = repository.updateRecruiterById(id)
            updateRecruiterByIdResponse.value = response
        }
    }
}