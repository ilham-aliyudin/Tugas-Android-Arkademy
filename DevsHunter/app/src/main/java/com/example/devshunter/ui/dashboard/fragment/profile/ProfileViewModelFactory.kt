package com.example.devshunter.ui.dashboard.fragment.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devshunter.repository.RecruiterRepository

class ProfileViewModelFactory(val repository: RecruiterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}