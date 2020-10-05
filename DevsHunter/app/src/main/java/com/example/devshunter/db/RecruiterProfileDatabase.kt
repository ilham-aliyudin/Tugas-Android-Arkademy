package com.example.devshunter.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.devshunter.models.RecruiterProfileEntity

@Database(entities = [RecruiterProfileEntity::class], version = 1, exportSchema = false)
abstract class RecruiterProfileDatabase : RoomDatabase() {

    abstract val recruiterProfileDao: RecruiterProfileDao

    companion object {
        @Volatile
        private var INSTANCE: RecruiterProfileDatabase? = null

        fun getInstance(context: Context?): RecruiterProfileDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = databaseBuilder(
                        context!!.applicationContext,
                        RecruiterProfileDatabase::class.java,
                        "db_recruiter_profile"
                    )
                        .allowMainThreadQueries() //allows Room to executing task in main thread
                        .fallbackToDestructiveMigration() //allows Room to recreate database if no migrations found
                        .build()
                }
                return instance
            }
        }
    }
}