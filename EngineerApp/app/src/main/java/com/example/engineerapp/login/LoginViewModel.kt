package com.example.engineerapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engineerapp.utils.api.RetrofitInstance
import com.example.engineerapp.utils.services.UserService
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel: ViewModel () {

    val retrofit = RetrofitInstance.userService
    val responseUserLogin: MutableLiveData<Response<LoginResponse>> = MutableLiveData()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            val response = retrofit?.loginUser(email, password)
            responseUserLogin.value = response
        }
    }
}