package com.example.devshunter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
    }

    abstract fun getLayoutId(): Int

    fun setAnimation(context: Context, id: Int): Animation {
        return AnimationUtils.loadAnimation(context, id)
    }

    abstract fun initListener()

    abstract fun setView()
}