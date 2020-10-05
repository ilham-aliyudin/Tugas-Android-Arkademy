package com.example.devshunter.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.devshunter.R
import com.example.devshunter.BaseActivity
import com.example.devshunter.api.RetrofitInstance
import com.example.devshunter.ui.register.RegisterActivity
import com.example.devshunter.databinding.ActivityLoginBinding
import com.example.devshunter.models.LoginResponse
import com.example.devshunter.ui.dashboard.DashboardActivity
import com.example.devshunter.ui.fragment.home.HomeFragment
import com.example.devshunter.util.SharedPrefUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.launch

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
                    lifecycleScope.launch {
                        try {
                            val response = RetrofitInstance.userApi.loginRequest(loginName, loginPass)
                            if (response.isSuccessful) {
                                val token = response.body()?.message?.token
                                pref.savePref(GET_PREF, token!!)
                                startActivity(Intent(applicationContext, DashboardActivity::class.java))
                            } else {
                                Toast.makeText(applicationContext, "Password/Email Salah",Toast.LENGTH_LONG).show()
                            }
                        } catch (e: Throwable) {
                            Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    etEmailLogin.error = "Username tidak boleh kosong"
                    etPasswordLogin.error = "Password tidak boleh kosong"
                }
            }
        }
    }
}