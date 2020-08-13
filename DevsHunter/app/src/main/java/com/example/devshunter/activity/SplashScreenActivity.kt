package com.example.devshunter.activity

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.telephony.SubscriptionPlan
import android.util.Pair
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()

        setAnimation()
        handler.postDelayed({
            val intent = Intent(this, IntroSliderActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, iv_arkademy,
                ViewCompat.getTransitionName(iv_arkademy)!!
            )
            startActivity(intent, options.toBundle())
            finish()
        }, 4000)
    }

    private fun setAnimation() {
        val animationZoomIcon = AnimationUtils.loadAnimation(this,
            R.anim.ic_splash_zoom_out)
        val animationBottomToTop = AnimationUtils.loadAnimation(this,
            R.anim.tv_splash_bottom_to_top)
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        iv_splash_icon.startAnimation(animationZoomIcon)
        tv_splash_bottom_to_mid.startAnimation(animationBottomToTop)
    }
}