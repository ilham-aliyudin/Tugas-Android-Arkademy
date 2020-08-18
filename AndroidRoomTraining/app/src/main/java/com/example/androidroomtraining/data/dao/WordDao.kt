package com.example.androidroomtraining.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.androidroomtraining.models.WordModel

interface WordDao {

    @Query("select * from word_table order by word ASC")
    fun getAlphabetizedWords(): LiveData<List<WordModel>>

    @Insert
    suspend fun insert(word: WordModel)

    @Query("delete from word_table")
    suspend fun deleteAll()
}