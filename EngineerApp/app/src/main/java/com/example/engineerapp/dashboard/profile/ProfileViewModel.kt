package com.example.engineerapp.dashboard.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engineerapp.dashboard.home.EngineerResponse
import com.example.engineerapp.dashboard.profile.fragment.PortfolioResponse
import com.example.engineerapp.utils.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class ProfileViewModel: ViewModel() {

    val retrofit = RetrofitInstance.engineerService
    val responseEngineerProfile: MutableLiveData<Response<EngineerByIdResponse>> = MutableLiveData()
    val responseCreateEngineerProfile: MutableLiveData<Response<PostEngineerResponse>> = MutableLiveData()
    val responseGetPortfolio: MutableLiveData<Response<PortfolioResponse>> = MutableLiveData()

    fun getProfile(id: Int) {
        viewModelScope.launch {
            val response = retrofit?.getEngineerProfile(id)
            responseEngineerProfile.value = response
        }
    }

    fun createProfile(
            idUser: Int, name: String, jobDesc: String, lokasi: String, status: String, deskripsi: String, skill: String
    ) {
        viewModelScope.launch {
            val response = retrofit?.createEngineer(idUser, name, jobDesc, lokasi, status, deskripsi, skill )
            responseCreateEngineerProfile.value = response
        }
    }

    fun getPortfolio(id: Int) {
        viewModelScope.launch {
            val response = retrofit?.getPortfolio(id)
            responseGetPortfolio.value = response
        }
    }
}