package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.devshunter.R
import com.example.devshunter.adapters.IntroSliderAdapter
import com.example.devshunter.animation.ViewPagerSliderTransformation
import com.example.devshunter.models.IntroSliderModel
import kotlinx.android.synthetic.main.activity_intro.*

class IntroSliderActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setIntroSlider()
        IntroSliderModel.getIntroData()
    }

    private fun setIntroSlider() {
        val offscreenPageLimit = 3
        vp_container.adapter = IntroSliderAdapter(IntroSliderModel.getIntroData())
        indicator.setViewPager(vp_container)
        vp_container.setPageTransformer(ViewPagerSliderTransformation(offscreenPageLimit))
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_intro
    }

    override fun initListener() {
        btn_skip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun setView() {
        TODO("Not yet implemented")
    }
}