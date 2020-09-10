package com.example.devshunter.ui.splashscreen


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.example.devshunter.R
import com.example.devshunter.BaseActivity
import com.example.devshunter.ui.dashboard.DashboardActivity
import com.example.devshunter.ui.introslider.IntroSliderActivity
import com.example.devshunter.util.SharedPrefUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : BaseActivity() {
    companion object {
        const val GET_BOOLEAN = "false"
    }
    private lateinit var pref: SharedPrefUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()
        pref = SharedPrefUtils(this)
        setAnimation()

        handler.postDelayed({
            if(pref.getBooleanPref(GET_BOOLEAN)!!) {
                startActivity(Intent(applicationContext, DashboardActivity::class.java))
            } else {
                startActivity(Intent(applicationContext, IntroSliderActivity::class.java))
                finish()
            }
        }, 4000)
    }

    private fun setAnimation() {
        val animationZoomIcon = setAnimation(this,
            R.anim.ic_splash_zoom_out)
        val animationBottomToTop = setAnimation(this,
            R.anim.tv_splash_bottom_to_top)
        val animationFadeIn = setAnimation(this, R.anim.fade_in)
//        iv_splash_icon.startAnimation(animationZoomIcon)
        tv_splash_bottom_to_mid.startAnimation(animationBottomToTop)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash_screen
    }
    override fun initListener() {}
    override fun setView() {}
}