package com.example.devshunter.ui.dashboard.fragment.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.adapters.EngineerAdapter
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.repository.EngineerRepository
import com.example.devshunter.ui.engineerprofiledetail.EngineerProfileDetail
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    companion object {
        const val PUT_PARCEL_EXTRA = "0000"
    }
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: EngineerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        view.toolbar_home.setupWithNavController(navController, appBarConfiguration)
        adapter = EngineerAdapter {
            val intent = Intent(activity, EngineerProfileDetail::class.java)
            intent.putExtra(PUT_PARCEL_EXTRA, it)
            startActivity(intent)
        }
        setUpRecyclerView()

        val repository = EngineerRepository()
        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        viewModel.getAllEngineers()
        viewModel.engineerResponse.observe(viewLifecycleOwner, {response ->
            if (response.isSuccessful) {
                val list: List<EngineerModel>? = response.body()?.map {
                    EngineerModel(it.nama, it.jobdesc, it.lokasi, it.status, it.deskripsi, it.skill )
                }
                adapter.setData(list!! as ArrayList<EngineerModel>)
            }
        })
    }

    private fun setUpRecyclerView() {
        rv_engineer.adapter = adapter
        rv_engineer.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
    }
}