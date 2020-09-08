package com.example.devshunter.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(){
    companion object {
        const val PUT_PREF = "0000"
    }
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var pref: SharedPreferences

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initListener() {
        tv_regis_sign_in.setOnClickListener {
            startActivity(Intent(this, RegisterAsDevsActivity::class.java))
        }
        btn_register.setOnClickListener {
            register()
        }
    }

    private fun register() {
        binding.apply {
            pref = getSharedPreferences(PUT_PREF, Context.MODE_PRIVATE)
            val email = etEmail.text.toString()
            val password  = etPassword.text.toString()
            val editor = pref.edit()
            editor.apply {
                putString(PUT_PREF, email)
                putString(PUT_PREF, password)
            }.apply()
        }
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun setView() {
    }
}