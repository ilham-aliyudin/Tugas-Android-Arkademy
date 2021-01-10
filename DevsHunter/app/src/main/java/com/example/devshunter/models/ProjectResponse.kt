package com.example.devshunter.models

import com.google.gson.annotations.SerializedName

data class ProjectResponse(val status: String?, val message: List<ProjectData>?) {
    data class ProjectData(
        @SerializedName("project_name") val projectName: String?,
        @SerializedName("description") val projectDescription: String?,
        @SerializedName("nama") val recruiterName: String?,
        @SerializedName("bidang") val bidang: String?,
        @SerializedName("lokasi") val lokasi: String?,
        @SerializedName("deadline") val deadline: String
    )
}