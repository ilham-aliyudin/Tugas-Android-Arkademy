package com.example.devshunter.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityRegisterAsDevsBinding
import com.example.devshunter.models.RecruiterProfileEntity
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.ui.profile.RecruiterProfileActivity

class RegisterAsDevsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PARCEL = "000"
    }
    private lateinit var binding: ActivityRegisterAsDevsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_as_devs)

//        binding.apply {
//            tvSignIn.setOnClickListener {
//                startActivity(Intent(application, LoginActivity::class.java))
//            }
//
//            btnDevRegister.setOnClickListener {
//                val name = etDevFullname.text.toString()
//                val email = etDevEmail.text.toString()
//                val adress = etDevAdress.text.toString()
//                val phone = etDevPhone.text.toString()
//                val devs = etProfileJobdesc.text.toString()
//                val userList = RecruiterProfileEntity(name, email, adress, phone, devs)
//                val intent = Intent(application, RecruiterProfileActivity::class.java)
//                intent.putExtra(EXTRA_PARCEL, userList)
//                startActivity(intent)
//            }
//        }
    }
}