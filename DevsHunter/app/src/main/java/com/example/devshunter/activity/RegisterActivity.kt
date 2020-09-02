package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.devshunter.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(){
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initListener() {
        tv_regis_sign_in.setOnClickListener {
            startActivity(Intent(this, RegisterAsDevsActivity::class.java))
        }
    }

    override fun setView() {
        TODO("Not yet implemented")
    }

//    override fun onClick(p0: View) {
//       when(p0.id) {
//           R.id.tv_regis_sign_in -> {
//                startActivity(Intent(this, RegisterAsDevsActivity::class.java))
//           }
//       }
//    }

//    private fun setAnimation() {
//        val animationBottoTop = AnimationUtils.loadAnimation(this, R.anim.fade_in)
//        cv_register_container.startAnimation(animationBottoTop)
//    }

}