package com.example.devshunter.ui.engineerprofiledetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityEngineerProfileDetailBinding
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.models.EngineerResponse
import com.example.devshunter.repository.EngineerRepository
import com.example.devshunter.ui.fragment.home.HomeFragment
import com.example.devshunter.ui.fragment.home.HomeViewModel
import retrofit2.http.GET

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