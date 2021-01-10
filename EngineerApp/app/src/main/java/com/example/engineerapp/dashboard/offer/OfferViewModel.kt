package com.example.engineerapp.dashboard.offer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engineerapp.utils.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class OfferViewModel: ViewModel() {

    val retrofit = RetrofitInstance.offerService
    val responseOffer: MutableLiveData<Response<OfferResponse>> = MutableLiveData()

    suspend fun getHireByIdEngineer(id: Int) {
        viewModelScope.launch {
            val response = retrofit?.getHiringById(id)
            responseOffer.value = response
        }
    }
}