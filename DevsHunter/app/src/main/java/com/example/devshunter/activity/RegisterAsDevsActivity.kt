package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.devshunter.R
import com.example.devshunter.models.UserProfile
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register_as_devs.*

class RegisterAsDevsActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_PARCEL = "000"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_as_devs)

        tv_sign_in.setOnClickListener(this)
        btn_dev_register.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id) {
            R.id.btn_dev_register -> {
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
            R.id.tv_sign_in -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}