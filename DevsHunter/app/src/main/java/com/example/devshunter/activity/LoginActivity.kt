package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAnimation()
        initListener()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initListener() {
        btn_sign_in.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }

    override fun setView() {
    }

    private fun setAnimation() {
        val animationToLeft = setAnimation(this, R.anim.left)
        val animationToRight = setAnimation(this, R.anim.right)
        val animationFadeIn: Animation = setAnimation(this, R.anim.fade_in)
        iv_login.startAnimation(animationFadeIn)
        tv_welcome_back.startAnimation(animationToRight)
        tv_please_log_in.startAnimation(animationToLeft)
    }
}