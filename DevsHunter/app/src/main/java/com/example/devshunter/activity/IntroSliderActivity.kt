package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.adapters.IntroSliderAdapter
import com.example.devshunter.animation.ViewPagerSliderTransformation
import com.example.devshunter.databinding.ActivityIntroBinding
import com.example.devshunter.models.IntroSliderModel
import kotlinx.android.synthetic.main.activity_intro.*

class IntroSliderActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        IntroSliderModel.getIntroData()

        setIntroSlider()
        binding.btnSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setIntroSlider() {
        val offscreenPageLimit = 3
        binding.apply {
            vpContainer.adapter = IntroSliderAdapter(IntroSliderModel.getIntroData())
            indicator.setViewPager(vpContainer)
            vpContainer.setPageTransformer(ViewPagerSliderTransformation(offscreenPageLimit))
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_intro
    }

    override fun initListener() {
    }

    override fun setView() {
    }
}