package com.example.engineerapp.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.engineerapp.R
import com.example.engineerapp.onboard.OnBoardActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()

        handler.postDelayed({
            startActivity(Intent(applicationContext, OnBoardActivity::class.java))
        }, 4000)
    }
}
