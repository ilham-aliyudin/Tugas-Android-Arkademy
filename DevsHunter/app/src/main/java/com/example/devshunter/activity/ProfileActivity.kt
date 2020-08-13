package com.example.devshunter.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devshunter.R
import com.example.devshunter.models.UserProfile
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PARCEL = "000"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val getData = intent.getParcelableExtra<UserProfile>(EXTRA_PARCEL) as UserProfile
        tv_profile_name.text = getData.name
        tv_profle_name2.text = getData.name
        tv_profile_email.text = getData.email
        tv_profile_adress.text = getData.adress
        tv_profile_contact.text = getData.contact
        tv_profile_jobdesc.text = getData.job
        iv_to_setting.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}