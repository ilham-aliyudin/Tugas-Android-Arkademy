package com.example.devshunter.models


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.devshunter.db.RecruiterProfileDao
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_recruiter_profile")
@Parcelize
data class RecruiterProfileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recruiter_id") val recruiterId: Int,
    @ColumnInfo(name = "recruiter_name") val recruiterName: String?,
    @ColumnInfo(name = "recruiter_jobdesc")val recruiterJobdesc: String?,
    @ColumnInfo(name = "recruiter_address")val recruiterAdress: String?,
    @ColumnInfo(name = "recruiter_desc")val recruiterDesc: String?,
    @ColumnInfo(name = "recruiter_email")val recruiterEmail: String?,
    @ColumnInfo(name = "recruiter_phone")val recruiterPhone: String?,
    @ColumnInfo(name = "recruiter_linked_in")val recruiterLinkedIn: String?
): Parcelable