package com.example.devshunter.ui.dashboard.fragment.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.devshunter.R
import com.example.devshunter.models.RecruiterByIdResponse
import com.example.devshunter.repository.RecruiterRepository
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.ui.profile.RecruiterProfileActivity
import com.example.devshunter.util.sharedpreference.SharedPrefUtils
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var pref: SharedPrefUtils
    private lateinit var viewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = SharedPrefUtils(context)
        val navController = findNavController()
        toolbar_profile.setupWithNavController(navController)
        val repository = RecruiterRepository()
        val factory = ProfileViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]
        val idUser = pref.getIntPref(LoginActivity.SAVE_USER_ID)

        btn_recruiter_profile_update.setOnClickListener {
            viewModel.createRecruiter(
                idUser,
                "PT Gudang Garam",
                "Jawa Timur",
                "Perusahaan Perbankan",
                "Pabrik Rokok",
                1234567,
                "HRD",
                "linkedinKu"
            )
            viewModel.postRecruiterResponse.observe(viewLifecycleOwner, { response ->
                if (response.isSuccessful) {
                    Log.d("Body", response.body().toString())
                } else {
                    Log.d("Body", response.code().toString())
                }
            })
        }

        viewModel.getRecruiterById(44)
        viewModel.getRecruiterByIdResponse.observe(viewLifecycleOwner, { response ->
           if (response.isSuccessful) {
               response.body()?.result?.map {
                   tv_recruiter_profile_email.text = it.userEmail
                   tv_recruiter_profile_jobdesc.text = it.bidang
                   tv_recruiter_profile_location.text = it.lokasi
                   tv_recruiter_profile_name.text = it.nama
               }
           }
        })


        iv_menu.setOnClickListener {
            profile_drawer.openDrawer(GravityCompat.END)
        }

        drawer_menu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_faq -> Toast.makeText(context, "FAQ Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_help -> Toast.makeText(context, "Help Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_about_us -> Toast.makeText(context, "About Us Diklik", Toast.LENGTH_SHORT)
                    .show()
                R.id.item_edit_profile -> startActivity(
                    Intent(
                        activity,
                        RecruiterProfileActivity::class.java
                    )
                )
                R.id.item_logout -> exitDialog()
            }
            return@setNavigationItemSelectedListener true
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















//    private fun setRecruiterProfile() {
//            val recruiterProfileData= db.recruiterProfileDao.getRecruiterProfile()
//            tv_recruiter_profile_name.text = recruiterProfileData?.recruiterName.toString()
//            tv_recruiter_profile_jobdesc.text = recruiterProfileData?.recruiterJobdesc.toString()
//            tv_recruiter_profile_location.text = recruiterProfileData?.recruiterAdress.toString()
//            tv_recruiter_profile_linkedin.text = recruiterProfileData?.recruiterLinkedIn.toString()
//            tv_recruiter_profile_phone.text = recruiterProfileData?.recruiterPhone.toString()
}

//    @SuppressLint("SetJavaScriptEnabled")
//    fun setWebView() {
//        web.apply {
//            loadUrl("https://github.com/ilham-aliyudin")
//            settings.javaScriptEnabled = true
//            webChromeClient = WebChromeClient()
//        }
//        web.webViewClient = object : WebViewClient() {
//            override fun onPageFinished(view: WebView?, url: String?) {
//                progress_bar?.visibility = View.GONE
//                web.visibility = View.VISIBLE
//                super.onPageFinished(view, url)
//            }
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                progress_bar?.visibility = View.VISIBLE
//                super.onPageStarted(view, url, favicon)
//            }