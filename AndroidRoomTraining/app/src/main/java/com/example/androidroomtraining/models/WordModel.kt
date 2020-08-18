package com.example.androidroomtraining.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class WordModel (
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)