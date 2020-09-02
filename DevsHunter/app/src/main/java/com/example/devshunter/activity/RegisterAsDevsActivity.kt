package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.devshunter.R
import com.example.devshunter.models.UserProfile
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register_as_devs.*

class RegisterAsDevsActivity : BaseActivity() {

    companion object {
        const val EXTRA_PARCEL = "000"
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_register_as_devs
    }

    override fun initListener() {
        tv_sign_in.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_dev_register.setOnClickListener {
            val name = et_dev_fullname.text.toString()
            val email = et_dev_email.text.toString()
            val adress = et_dev_adress.text.toString()
            val phone = et_dev_phone.text.toString()
            val devs = et_profile_jobdesc.text.toString()
            val userList = UserProfile(name, email, adress, phone, devs)
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(EXTRA_PARCEL, userList)
            startActivity(intent)
        }
    }

    override fun setView() {
        TODO("Not yet implemented")
    }
}