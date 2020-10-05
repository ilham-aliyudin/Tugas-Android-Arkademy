package com.example.devshunter.db


import androidx.room.*
import com.example.devshunter.models.RecruiterProfileEntity


@Dao
interface RecruiterProfileDao {

    @Query("SELECT * FROM tb_recruiter_profile")
    fun getRecruiterProfile(): RecruiterProfileEntity?

    @Query("SELECT * FROM tb_recruiter_profile WHERE recruiter_id = :id")
    fun getRecruiterProfileById(id: Int): RecruiterProfileEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createRecruiterProfile(recruiter: RecruiterProfileEntity): Long

    @Update
    fun updaterRecruiterProfile(recruiter: RecruiterProfileEntity)
}