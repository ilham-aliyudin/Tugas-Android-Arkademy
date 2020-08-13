package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setAnimation()
        btn_sign_in.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    private fun setAnimation() {
        val animationToLeft = AnimationUtils.loadAnimation(this, R.anim.left)
        val animationToRight = AnimationUtils.loadAnimation(this, R.anim.right)
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        iv_login.startAnimation(animationFadeIn)
        tv_welcome_back.startAnimation(animationToRight)
        tv_please_log_in.startAnimation(animationToLeft)
    }
}