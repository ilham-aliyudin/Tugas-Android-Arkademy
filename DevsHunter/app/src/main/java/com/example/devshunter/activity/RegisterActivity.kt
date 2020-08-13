package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        setAnimation()
       btn_register_as_dev.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
       when(p0.id) {
           R.id.btn_register_as_dev -> {
                startActivity(Intent(this, RegisterAsDevsActivity::class.java))
           }
       }
    }

//    private fun setAnimation() {
//        val animationBottoTop = AnimationUtils.loadAnimation(this, R.anim.fade_in)
//        cv_register_container.startAnimation(animationBottoTop)
//    }

}