package com.example.devshunter.models

import com.example.devshunter.R

data class ProjectModel(val image: Int, val project: String) {

    companion object {
        var projectLIst = arrayListOf(
            ProjectModel(R.drawable.photo, "PROJECT 1"),
            ProjectModel(R.drawable.photo, "PROJECT 2"),
            ProjectModel(R.drawable.photo, "PROJECT 3"),
            ProjectModel(R.drawable.photo, "PROJECT 4"),
            ProjectModel(R.drawable.photo, "PROJECT 5"),
            ProjectModel(R.drawable.photo, "PROJECT 6"),
            ProjectModel(R.drawable.photo, "PROJECT 8"),
            ProjectModel(R.drawable.photo, "PROJECT 9"),
            ProjectModel(R.drawable.photo, "PROJECT 10"),
            ProjectModel(R.drawable.photo, "PROJECT 11"),
            ProjectModel(R.drawable.photo, "PROJECT 12"),
            ProjectModel(R.drawable.photo, "PROJECT 13"),
        )
    }
}