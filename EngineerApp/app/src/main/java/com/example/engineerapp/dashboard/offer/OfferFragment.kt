package com.example.engineerapp.dashboard.offer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.engineerapp.R
import com.example.engineerapp.utils.preferences.Constants
import com.example.engineerapp.utils.preferences.PreferenceHelper
import kotlinx.android.synthetic.main.fragment_offer.*
import kotlinx.coroutines.launch


class OfferFragment : Fragment(R.layout.fragment_offer) {

    private lateinit var viewModel: OfferViewModel
    private lateinit var adapter: OfferAdapter
    private lateinit var pref: PreferenceHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OfferViewModel::class.java]
        adapter = OfferAdapter {
            val intent = Intent(activity, OfferDetailActivity::class.java)
            intent.putExtra(Constants.INTENT_KEY, it )
            startActivity(intent)
        }
        pref = PreferenceHelper(context)

        getOffer()
        subsribeLiveData()
        setOfferRv()

    }

    private fun getOffer() {
        lifecycleScope.launch {
            viewModel.getHireByIdEngineer(24)
        }
    }

    private fun subsribeLiveData() {
        viewModel.responseOffer.observe(viewLifecycleOwner, {response ->
            if (response.isSuccessful) {
                val list = response.body()?.data?.map {
                    OfferModel(it.confirm_status, it.deadline, it.description, it.nama, it.price, it.project_name)
                }
                adapter.setData(list as ArrayList<OfferModel>)
            }
        })
    }

    private fun setOfferRv() {
        rv_offer.adapter = adapter
        rv_offer.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun offerDetailDialog() {

    }
}