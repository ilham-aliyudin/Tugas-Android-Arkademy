package com.example.devshunter.ui.dashboard.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devshunter.repository.EngineerRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val repository: EngineerRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}