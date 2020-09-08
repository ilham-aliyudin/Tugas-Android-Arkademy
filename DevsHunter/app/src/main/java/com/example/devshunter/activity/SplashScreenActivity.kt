package com.example.devshunter.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        val handler = Handler()

        setAnimation()
        handler.postDelayed({
            val intent = Intent(this, IntroSliderActivity::class.java)
            startActivity(intent)
            finish()
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

    override fun initListener() {
    }

    override fun setView() {
    }
}