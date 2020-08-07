package com.example.arkademyday_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val getName = intent.getStringExtra("Test")
        Log.d("Data", getName.toString())
        tv_profile_name.text = getName.toString()
    }
}