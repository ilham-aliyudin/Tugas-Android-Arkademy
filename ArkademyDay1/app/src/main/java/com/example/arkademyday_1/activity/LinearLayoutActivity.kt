package com.example.arkademyday_1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arkademyday_1.R
import kotlinx.android.synthetic.main.activity_linear_layout.*

class LinearLayoutActivity : AppCompatActivity() {

    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        btn_submit.setOnClickListener {
            name = et_name.text.toString()
            val intent = Intent(this, GreetingActivity::class.java)
            intent.putExtra("Test", name )
            startActivity(intent)
        }
    }
}