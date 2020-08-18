package com.example.androidroomtraining.data.dao.repository

import com.example.androidroomtraining.data.dao.WordDao
import com.example.androidroomtraining.models.WordModel

class WordRepository(private val wordDao: WordDao){

    val allWords = wordDao.getAlphabetizedWords()

    suspend fun insert(word: WordModel) {
        wordDao.insert(word)
    }
}