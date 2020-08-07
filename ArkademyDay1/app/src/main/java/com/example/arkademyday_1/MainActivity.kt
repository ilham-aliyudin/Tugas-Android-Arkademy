package com.example.arkademyday_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_to_activityB.setOnClickListener(this)
        btn_to_activity_linearlayout.setOnClickListener(this)
        btn_to_activity_relativelayout.setOnClickListener(this)
        btn_to_activity_framelayout.setOnClickListener(this)
        btn_to_activity_constraintlayout.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btn_to_activityB -> {
                startActivity(Intent(this, MainActivity2::class.java ))
            }
            R.id.btn_to_activity_linearlayout -> {
                startActivity(Intent(this, LinearLayoutActivity::class.java ))
            }
            R.id.btn_to_activity_relativelayout -> {
                startActivity(Intent(this, RelativeLayoutActivity::class.java ))
            }
            R.id.btn_to_activity_framelayout -> {
                startActivity(Intent(this, FrameLayoutActivity::class.java ))
            }
            R.id.btn_to_activity_constraintlayout -> {
                startActivity(Intent(this, ConstraintLayoutActivity::class.java ))
            }
        }
    }
}