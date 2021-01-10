package com.example.engineerapp.register

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.engineerapp.utils.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    val retrofit = RetrofitInstance.userService

    var reponseUserRegister: MutableLiveData<Response<RegisterResponse>> = MutableLiveData()

    fun createUser(
        userName: String,
        userEmail: String,
        phone: String,
        userPassword: String,
        userRole: Int,
        userStatus: Int,
        userCreated: String
    ) {
        viewModelScope.launch {
            val response = retrofit?.registerUser(
                userName, userEmail, phone, userPassword, userRole, userStatus, userCreated
            )
            reponseUserRegister.value = response
        }
    }
}