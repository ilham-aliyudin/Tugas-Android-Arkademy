package com.example.engineerapp.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.engineerapp.R
import com.example.engineerapp.dashboard.DashboardActivity
import com.example.engineerapp.databinding.ActivityOnBoardBinding
import com.example.engineerapp.login.LoginActivity
import com.example.engineerapp.register.RegisterActivity
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper

class OnBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardBinding
    private lateinit var pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_board)
        pref = PreferenceHelper(this)

        binding.btnMasuk.setOnClickListener {
            if (pref.getStringPref(Constants.TOKEN) is String) {
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}