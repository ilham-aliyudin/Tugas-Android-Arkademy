package com.example.devshunter.ui.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityProfileBinding
import com.example.devshunter.db.RecruiterProfileDatabase
import com.example.devshunter.models.RecruiterProfileEntity
import kotlinx.coroutines.launch

class RecruiterProfileActivity : AppCompatActivity() {

    private lateinit var db: RecruiterProfileDatabase
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        db = RecruiterProfileDatabase.getInstance(application)

        binding.apply {
            btnRecruiterSave.setOnClickListener{
                insertRecruiterProfile()
                Toast.makeText(application, "Data Tersimpan", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun insertRecruiterProfile() {
        lifecycleScope.launch {
            val dao = db.recruiterProfileDao
            binding.apply {
                val recruiterName = etRecruiterName.text.toString()
                val recruiterJobdesc = etRecruiterJobdesc.text.toString()
                val recruiterAdress = etRecruiterAdresss.text.toString()
                val recruiterDesc = etRecruiterDesc.text.toString()
                val recruiterEmail = etRecruiterEmail.text.toString()
                val recruiterPhone = etRecruiterPhone.text.toString()
                val recruiteLinkedIn = etRecruiterLinkedIn.text.toString()

                dao.createRecruiterProfile(
                    RecruiterProfileEntity(
                        0,
                        recruiterName,
                        recruiterJobdesc,
                        recruiterAdress,
                        recruiterDesc,
                        recruiterEmail,
                        recruiterPhone,
                        recruiteLinkedIn)
                )
            }
        }
    }


//    companion object {
//        const val EXTRA_PARCEL = "000"
//    }
//
//    override fun getLayoutId(): Int {
//        return R.layout.activity_profile
//    }
//
//    override fun initListener() {
//    }

//    override fun setView() {
//        val getData = intent.getParcelableExtra<RecruiterProfileEntity>(EXTRA_PARCEL)
//        tv_profile_name.text = getData?.name
//        tv_profle_name2.text = getData?.name
//        tv_profile_email.text = getData?.email
//        tv_profile_adress.text = getData?.adress
//        tv_profile_contact.text = getData?.contact
//        tv_profile_jobdesc.text = getData?.job
//    }
}