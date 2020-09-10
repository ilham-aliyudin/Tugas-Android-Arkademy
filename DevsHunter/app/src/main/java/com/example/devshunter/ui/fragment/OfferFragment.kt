package com.example.devshunter.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.devshunter.R
import kotlinx.android.synthetic.main.fragment_offer.view.*


class OfferFragment : Fragment(R.layout.fragment_offer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        view.toolbar_offer.setupWithNavController(navController, appBarConfiguration)

    }
}