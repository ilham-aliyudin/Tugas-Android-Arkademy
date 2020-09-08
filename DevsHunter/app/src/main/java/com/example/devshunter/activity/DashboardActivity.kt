package com.example.devshunter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityDashboardBinding
import com.example.devshunter.fragment.HomeFragment
import com.example.devshunter.fragment.OfferFragment
import com.example.devshunter.fragment.ProfileFragment
import com.example.devshunter.fragment.ProjectFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        navController = findNavController(R.id.nav_host_fragment)
        binding.apply {
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}