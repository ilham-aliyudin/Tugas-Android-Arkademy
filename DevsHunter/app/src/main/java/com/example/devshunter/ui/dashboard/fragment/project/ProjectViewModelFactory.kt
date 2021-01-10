package com.example.devshunter.ui.dashboard.fragment.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devshunter.repository.ProjectRepository

class ProjectViewModelFactory(val repository: ProjectRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProjectViewModel(repository) as T
    }

}