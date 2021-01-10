package com.example.engineerapp.dashboard.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.engineerapp.R
import com.example.engineerapp.dashboard.profile.fragment.ViewPagerAdapter
import com.example.engineerapp.login.LoginActivity
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.launch


class ProfileFragment : Fragment(R.layout.fragment_profile), View.OnClickListener {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var pref: PreferenceHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        pref = PreferenceHelper(activity)
        iv_profile_setting.setOnClickListener(this)
        tv_profile_logout.setOnClickListener(this)

        getProfile()
        subscribeLiveData()
        setUpProfileViewPager()
    }

    private fun getProfile() {
        lifecycleScope.launch {
            val id = pref.getStringPref(Constants.ID_USER)?.toInt()
            viewModel.getProfile(id!!)
        }
    }

    private fun subscribeLiveData() {
        viewModel.responseEngineerProfile.observe(viewLifecycleOwner, {response ->
            if (response.isSuccessful) {
                val data = response.body()?.data?.map {
                    tv_fullname.text = it.nama
                    tv_profile_jobdesc.text = it.jobdesc
                    tv_profile_location.text = it.lokasi
                    textView12.text = it.status
                    tv_profile_email.text = it.user_email
                    tv_profile_phone.text = it.phone.toString()
                }
            }
        })
    }

    override fun onClick(p0: View?) {
        when(p0) {
            iv_profile_setting -> {startActivity(Intent(activity, FormProfileActivity::class.java))}
            tv_profile_logout ->{exitDialog()}
        }
    }

    private fun exitDialog() {
        val builder = AlertDialog.Builder(context)
        builder.apply {
            setTitle("Mau Kemana???")
            setMessage("Yakin Mau Keluar Kisanak??")
            setPositiveButton("Yes") { _: DialogInterface, _ ->
                startActivity(Intent(context, LoginActivity::class.java))
                pref.clearPref()
            }
            setNegativeButton("No") { _: DialogInterface, _ -> }
        }.show()
    }

    private fun setUpProfileViewPager() {
        vp_profile.adapter = fragmentManager?.let { ViewPagerAdapter(it) }
        tab_profile.setupWithViewPager(vp_profile)
    }
}