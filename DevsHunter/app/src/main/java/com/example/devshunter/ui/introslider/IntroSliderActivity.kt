package com.example.devshunter.ui.introslider

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.BaseActivity
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.adapters.IntroSliderAdapter
import com.example.devshunter.animation.ViewPagerSliderTransformation
import com.example.devshunter.databinding.ActivityIntroBinding
import com.example.devshunter.models.IntroSliderModel
import kotlinx.android.synthetic.main.activity_intro.*

class IntroSliderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        IntroSliderModel.getIntroData()
        setIntroSlider()
        binding.btnSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setIntroSlider() {
        val offscreenPageLimit = 3
            vp_container.adapter = IntroSliderAdapter(IntroSliderModel.getIntroData())
            indicator.setViewPager(vp_container)
            vp_container.setPageTransformer(ViewPagerSliderTransformation(offscreenPageLimit))
    }
}