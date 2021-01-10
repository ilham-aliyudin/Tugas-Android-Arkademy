package com.example.engineerapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.engineerapp.R
import com.example.engineerapp.dashboard.DashboardActivity
import com.example.engineerapp.databinding.ActivityLoginBinding
import com.example.engineerapp.onboard.OnBoardActivity
import com.example.engineerapp.register.RegisterActivity
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var pref : PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        pref = PreferenceHelper(this)

        binding.btnMasuk.setOnClickListener(this)
        binding.tvDaftarDisini.setOnClickListener(this)
        subsribeLiveData()
    }

    private fun loginUser () {
        binding.apply {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    viewModel.loginUser(email, password)
                }
            } else {
                Toast.makeText(applicationContext, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun subsribeLiveData() {
        viewModel.responseUserLogin.observe(this, {response ->
            if (response.isSuccessful) {
                val token = response.body()?.message?.token
                val userName = response.body()?.message?.user_name
                val idUser = response.body()?.message?.id.toString()
                pref.savePref(Constants.USERNAME, userName!!)
                pref.savePref(Constants.TOKEN, token!!)
                pref.savePref(Constants.ID_USER, idUser)
                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Login Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.btnMasuk -> {loginUser()}
            binding.tvDaftarDisini -> {startActivity(Intent(applicationContext, RegisterActivity::class.java))}
        }
    }
}