package com.example.devshunter.ui.dashboard.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devshunter.models.EngineerResponse
import com.example.devshunter.repository.EngineerRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: EngineerRepository): ViewModel() {

    val engineerResponse: MutableLiveData<Response<ArrayList<EngineerResponse>>> = MutableLiveData()

    fun getAllEngineers() {
        viewModelScope.launch {
            val response = repository.getAllEngineers()
            engineerResponse.value = response
        }
    }
}