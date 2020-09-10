package com.example.devshunter.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.*
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.devshunter.R
import com.example.devshunter.ui.login.LoginActivity
import com.example.devshunter.util.SharedPrefUtils
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var pref: SharedPrefUtils

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = SharedPrefUtils(context)
        val navController = findNavController()
//        val appBarConfiguration = AppBarConfiguration(navController.graph, view.profile_drawer)
        view.toolbar_profile.setupWithNavController(navController)
        iv_menu.setOnClickListener {
            profile_drawer.openDrawer(GravityCompat.END)
        }

        drawer_menu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_faq -> Toast.makeText(context, "FAQ Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_help -> Toast.makeText(context, "Help Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_about_us -> Toast.makeText(context, "About Us Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_logout -> exitDialog()
            }
            return@setNavigationItemSelectedListener true
        }

        iv_github.setOnClickListener {
            setWebView()
        }
    }

    private fun exitDialog() {
        val builder = AlertDialog.Builder(context)
        builder.apply {
            setTitle("Are U Ready To Lose")
            setMessage("Yakin Mau Keluar Kisanak??")
            setPositiveButton("Yes") { _: DialogInterface, _ ->
                startActivity(Intent(context, LoginActivity::class.java))
                pref.clearPref()
            }
            setNegativeButton("No") { _: DialogInterface, _ -> }
        }.show()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setWebView() {
        web!!.apply {
            loadUrl("https://github.com/ilham-aliyudin")
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
        }
    }
}