package com.example.devshunter.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.BaseActivity
import com.example.devshunter.ui.register.RegisterActivity
import com.example.devshunter.databinding.ActivityLoginBinding
import com.example.devshunter.ui.dashboard.DashboardActivity
import com.example.devshunter.util.SharedPrefUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object {
        const val GET_PREF = "0000"
        const val GET_BOOLEAN = "false"
    }
    private lateinit var pref: SharedPrefUtils
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        pref = SharedPrefUtils(this)

        binding.apply {
            btnSignUp.setOnClickListener {
                startActivity(Intent(applicationContext, RegisterActivity::class.java))
            }

            btnLogin.setOnClickListener {
                if (etEmailLogin.text.toString().isNotEmpty() || etPasswordLogin.text.toString().isNotEmpty()) {
                    val loginName = etEmailLogin.text.toString()
                    val loginPass = etPasswordLogin.text.toString()
                    val registName = pref.getStringPref(GET_PREF)
                    val registPass = pref.getStringPref(GET_PREF)
                    if (loginName == registName || loginPass == registPass) {
                        pref.saveBooleanPref(GET_BOOLEAN, true)
                        startActivity(Intent(applicationContext, DashboardActivity::class.java))
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (pref.getBooleanPref(GET_BOOLEAN)!!){
            startActivity(Intent(applicationContext, DashboardActivity::class.java))
            finish()
        }
    }
}