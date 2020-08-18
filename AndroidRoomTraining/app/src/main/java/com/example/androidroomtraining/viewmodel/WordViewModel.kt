package com.example.androidroomtraining.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.androidroomtraining.models.WordModel
import com.example.androidroomtraining.data.dao.repository.WordRepository
import com.example.androidroomtraining.data.dao.roomdatabase.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val repository: WordRepository
    private val allWord: LiveData<List<WordModel>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWord = repository.allWords
    }
    fun insert(word: WordModel) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.insert(word)
        }
    }
}