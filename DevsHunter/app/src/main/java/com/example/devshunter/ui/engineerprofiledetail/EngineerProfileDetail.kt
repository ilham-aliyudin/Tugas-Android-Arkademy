package com.example.devshunter.ui.engineerprofiledetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityEngineerProfileDetailBinding
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.ui.dashboard.fragment.home.HomeFragment

class EngineerProfileDetail : AppCompatActivity() {

    private lateinit var binding: ActivityEngineerProfileDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_engineer_profile_detail)
        val engineerModel: EngineerModel? = intent.getParcelableExtra<EngineerModel>(HomeFragment.PUT_PARCEL_EXTRA)

        binding.apply {
            tvEngineerProfileName.text = engineerModel?.nama.toString()
            tvEngineerProfileJobdesc.text = engineerModel?.jobdesc.toString()
            tvEngineerProfileLokasi.text = engineerModel?.lokasi.toString()
            tvEngineerDetailStatus.text = engineerModel?.status.toString()
            tvEngineerSkill.text = engineerModel?.skill.toString()
        }
    }
}