package com.example.devshunter.models

import com.example.devshunter.R

data class IntroSliderModel(val image: Int, val title: String, val description: String) {
    companion object {
        fun getIntroData() : ArrayList<IntroSliderModel> {
            val listIntro = ArrayList<IntroSliderModel>()

            val intro1 = IntroSliderModel(
                image = R.drawable.ic_no_hiring_fee,
                title = "No Hiring Fees",
                description = "We provide handpicked graduates as needed for free"
            )
            listIntro.add(intro1)

            val intro2 = IntroSliderModel(
                image = R.drawable.ic_team_collaboration,
                title = "Team Collaboration Skills",
                description = "Our graduates equipped with collaborative works & easily adapt to your culture"
            )
            listIntro.add(intro2)

            val intro3 = IntroSliderModel(
                image = R.drawable.ic_various_programming,
                title = "Various Programming Languages",
                description = "Our graduates have been provided with a variety of the latest programming languages"
            )
            listIntro.add(intro3)

            val intro4 = IntroSliderModel(
                image = R.drawable.ic_real_project,
                title = "Real Project Experience",
                description = "Our graduates are trained to work on coding and real projects"
            )
            listIntro.add(intro4)

            return listIntro
        }
    }
}