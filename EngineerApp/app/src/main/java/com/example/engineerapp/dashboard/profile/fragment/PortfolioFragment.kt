package com.example.engineerapp.dashboard.profile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.engineerapp.R
import com.example.engineerapp.dashboard.profile.ProfileViewModel
import kotlinx.coroutines.launch


class PortfolioFragment : Fragment(R.layout.fragment_portfolio) {

    private lateinit var viewModel: ProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        setPortfolio()
        subscribeLiveData()
    }

    private fun setPortfolio() {
        lifecycleScope.launch {
            viewModel.getPortfolio(36)
        }
    }

    private fun subscribeLiveData() {
        viewModel.responseGetPortfolio.observe(viewLifecycleOwner, {response ->
            if(response.isSuccessful) {
                Toast.makeText(activity, "Data Retrivied", Toast.LENGTH_SHORT).show()
            }
        })
    }
}