package com.example.engineerapp.dashboard.home

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
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel
    private lateinit var pref: PreferenceHelper
    private lateinit var adapter: EngineerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        pref = PreferenceHelper(context)
        adapter = EngineerAdapter()

        getAllEngineer()
        subscribeLiveData()
        setEngineerRecyclerView()
        initView()
    }

    private fun getAllEngineer() {
        lifecycleScope.launch {
            viewModel.getAllEngineer()
        }
    }

    private fun subscribeLiveData() {
        viewModel.responseEngineer.observe(viewLifecycleOwner, {response->
            if (response.isSuccessful) {
                val list: List<EngineerModel>? = response.body()?.map {
                    EngineerModel(it.deskripsi, it.id, it.id_user, it.jobdesc, it.lokasi, it.nama,  it.skill, it.status )
                }
                adapter.setData(list as ArrayList<EngineerModel>)
            }
        })
    }

    private fun setEngineerRecyclerView() {
        rv_engineer.adapter = adapter
        rv_engineer.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun initView() {
        val date = Calendar.getInstance().time
        val currentTime = DateFormat.getDateInstance(DateFormat.FULL).format(date)
        tv_username.text = pref.getStringPref(Constants.USERNAME)
        tv_tanggal.text = currentTime.toString()
    }
}