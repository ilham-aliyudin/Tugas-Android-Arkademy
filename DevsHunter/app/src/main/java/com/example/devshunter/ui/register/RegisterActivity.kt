package com.example.devshunter.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.devshunter.R
import com.example.devshunter.api.RetrofitInstance
import com.example.devshunter.databinding.ActivityRegisterBinding
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.util.SharedPrefUtils
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    companion object {
        const val SAVE_PREF = "0000"
    }

    private lateinit var pref: SharedPrefUtils
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        pref = SharedPrefUtils(this)


        binding.apply {
            btnRegister.setOnClickListener {
                val username = etUsername.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                if (username.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty()) {
                    lifecycleScope.launch {
                        try {
                            RetrofitInstance.userApi.registerRequest(username, email, password, 1, 1, "2020")
                            Toast.makeText(applicationContext, "Disimpan", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                        } catch (e: Throwable) {
                            Toast.makeText(applicationContext, e.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
//                    pref.apply {
//                        savePref(SAVE_PREF, etEmail.text.toString())
//                        savePref(SAVE_PREF, etPassword.text.toString())
//                    }
//                    Toast.makeText(application, "Data Tersimpan", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(application, LoginActivity::class.java))
                }
            }
        }
    }
}