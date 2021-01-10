package com.example.devshunter.ui.dashboard.fragment.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.devshunter.R
import com.example.devshunter.adapters.EngineerAdapter
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.repository.EngineerRepository
import com.example.devshunter.ui.engineerprofiledetail.EngineerProfileDetail
import com.example.devshunter.ui.dashboard.fragment.home.HomeFragment
import com.example.devshunter.ui.dashboard.fragment.home.HomeViewModel
import com.example.devshunter.ui.dashboard.fragment.home.HomeViewModelFactory
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*


class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: EngineerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EngineerAdapter {
            val intent = Intent(activity, EngineerProfileDetail::class.java)
            intent.putExtra(HomeFragment.PUT_PARCEL_EXTRA, it)
            startActivity(intent)
        }
        setRecyclerView()

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

        view.search_menu.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val data = p0.toString()
                Log.d("OnSubmit", adapter.filter.filter(data).toString())
                return true
            }
            override fun onQueryTextChange(p0: String?): Boolean {
//                adapter.filter.filter(p0)
                return false
            }
        })
   }

    private fun setRecyclerView() {
        rv_search_engineer.adapter = adapter
        rv_search_engineer.layoutManager = GridLayoutManager(activity, 2)
    }
}