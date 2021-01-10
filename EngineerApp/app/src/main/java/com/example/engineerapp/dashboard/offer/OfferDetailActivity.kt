package com.example.engineerapp.dashboard.offer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.engineerapp.R
import com.example.engineerapp.databinding.ActivityOfferDetailBinding
import com.example.engineerapp.utils.preferences.Constants
import kotlinx.android.synthetic.main.activity_offer_detail.*

class OfferDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfferDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offer_detail)
        val data = intent.getParcelableExtra<OfferModel>(Constants.INTENT_KEY)

        binding.apply {
            tvOfferDetailName.text = data?.project_name
            tvOfferDetailDesc.text = data?.description
        }
    }
}