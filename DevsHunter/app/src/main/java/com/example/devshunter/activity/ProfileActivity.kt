package com.example.devshunter.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devshunter.R
import com.example.devshunter.models.UserProfile
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    companion object {
        const val EXTRA_PARCEL = "000"
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_profile
    }

    override fun initListener() {
    }

    override fun setView() {
        val getData = intent.getParcelableExtra<UserProfile>(EXTRA_PARCEL)
        tv_profile_name.text = getData?.name
        tv_profle_name2.text = getData?.name
        tv_profile_email.text = getData?.email
        tv_profile_adress.text = getData?.adress
        tv_profile_contact.text = getData?.contact
        tv_profile_jobdesc.text = getData?.job
    }
}