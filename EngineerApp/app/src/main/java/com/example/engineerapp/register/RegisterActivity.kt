package com.example.engineerapp.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.engineerapp.R
import com.example.engineerapp.dashboard.profile.FormProfileActivity
import com.example.engineerapp.databinding.ActivityRegisterBinding
import com.example.engineerapp.login.LoginActivity
import kotlinx.coroutines.launch
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        binding.btnDaftar.setOnClickListener {
            createUser()
        }

        subsribeliveData()
    }

    private fun createUser() {
        binding.apply {
            val username = etNama.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val password = etKataSandi.text.toString()
            if (username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    viewModel.createUser(username, email, phone, password, 2, 2, "2020")
                }
            } else {
                Toast.makeText(applicationContext, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun subsribeliveData() {
        viewModel.reponseUserRegister.observe(this, {response ->
            if (response.isSuccessful) {
                Toast.makeText(this, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "${response.errorBody()}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}