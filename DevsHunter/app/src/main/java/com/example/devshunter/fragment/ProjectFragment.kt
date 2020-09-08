package com.example.devshunter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.adapters.ProjectAdapter
import com.example.devshunter.models.ProjectModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.android.synthetic.main.fragment_project.view.*

class ProjectFragment : Fragment(R.layout.fragment_project){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        view.toolbar_project.setupWithNavController(navController, appBarConfiguration)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        rv_container.adapter = ProjectAdapter(ProjectModel.projectLIst)
        rv_container.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }
}
