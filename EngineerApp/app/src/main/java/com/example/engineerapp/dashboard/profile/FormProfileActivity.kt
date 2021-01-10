package com.example.engineerapp.dashboard.profile

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
import com.example.engineerapp.databinding.ActivityFormProfileBinding
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import kotlinx.coroutines.launch

class FormProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var pref: PreferenceHelper
    private lateinit var binding: ActivityFormProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_form_profile)
        pref = PreferenceHelper(this)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.btnFormSimpan.setOnClickListener(this)
        binding.btnFormBatal.setOnClickListener(this)

        subscribeLiveData()
    }

    private fun createEngineer() {
        binding.apply {
            val name = etFormNama.text.toString()
            val jobDesc = etFormJobtitle.text.toString()
            val lokasi = etFormDomisili.text.toString()
            val deskripsi = etFormDeskripsi.text.toString()
            val status = etFormStatus.text.toString()
            val idUser = pref.getStringPref(Constants.ID_USER)?.toInt()
            lifecycleScope.launch {
                viewModel.createProfile(idUser!!, name, jobDesc, lokasi, deskripsi, status, "kotlin")
            }
        }
    }

    private fun subscribeLiveData() {
        viewModel.responseCreateEngineerProfile.observe(this, {response->
            if(response.isSuccessful) {
                Toast.makeText(this, "ProfileDitambahkan", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.btnFormSimpan -> {createEngineer()}
            binding.btnFormBatal -> {}
        }
    }
}