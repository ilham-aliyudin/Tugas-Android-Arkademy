package com.example.devshunter.ui.dashboard.fragment.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devshunter.models.ProjectResponse
import com.example.devshunter.repository.ProjectRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ProjectViewModel(private val repository: ProjectRepository): ViewModel() {

    val projectResponse: MutableLiveData<Response<ProjectResponse>> = MutableLiveData()

     fun getAllProject() {
        viewModelScope.launch {
            val response = repository.getAllProject()
            projectResponse.value = response
        }
    }
}