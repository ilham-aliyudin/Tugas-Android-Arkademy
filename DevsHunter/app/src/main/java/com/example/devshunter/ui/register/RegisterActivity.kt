package com.example.devshunter.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.BaseActivity
import com.example.devshunter.databinding.ActivityRegisterBinding
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.util.SharedPrefUtils

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
            tvRegisSignIn.setOnClickListener {
                startActivity(Intent(application, RegisterAsDevsActivity::class.java))
            }

            btnRegister.setOnClickListener {
                if (etEmail.text.toString().isNotEmpty() || etPassword.text.toString().isNotEmpty()) {
                    pref.apply {
                        savePref(SAVE_PREF, etEmail.text.toString())
                        savePref(SAVE_PREF, etPassword.text.toString())
                    }
                    Toast.makeText(application, "Data Tersimpan", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(application, LoginActivity::class.java))
                }
            }
        }
    }
}