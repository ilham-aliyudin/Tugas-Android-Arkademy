package com.example.devshunter.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.*
import android.webkit.RenderProcessGoneDetail
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
import com.bumptech.glide.load.model.ImageVideoWrapper
import com.example.devshunter.R
import com.example.devshunter.databinding.FragmentProfileBinding
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
        toolbar_profile.setupWithNavController(navController)

        iv_menu.setOnClickListener {
            profile_drawer.openDrawer(GravityCompat.END)
        }

        iv_github.setOnClickListener {
            setWebView()
        }

        drawer_menu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_faq -> Toast.makeText(context, "FAQ Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_help -> Toast.makeText(context, "Help Diklik", Toast.LENGTH_SHORT).show()
                R.id.item_about_us -> Toast.makeText(context, "About Us Diklik", Toast.LENGTH_SHORT)
                    .show()
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

    @SuppressLint("SetJavaScriptEnabled")
    fun setWebView() {
        web.apply {
            loadUrl("https://github.com/ilham-aliyudin")
            settings.javaScriptEnabled = true
            webChromeClient = WebChromeClient()
        }
        web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                progress_bar?.visibility = View.GONE
                web.visibility = View.VISIBLE
                super.onPageFinished(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progress_bar?.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }
        }
    }
}