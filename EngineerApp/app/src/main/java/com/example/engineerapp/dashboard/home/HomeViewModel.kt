package com.example.engineerapp.dashboard.home

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engineerapp.utils.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel: ViewModel() {

    val retrofit = RetrofitInstance.engineerService
    val responseEngineer: MutableLiveData<Response<EngineerResponse>> = MutableLiveData()

    fun getAllEngineer() {
        viewModelScope.launch {
            val response = retrofit?.getAllEngineer()
            responseEngineer.value = response
        }
    }
}