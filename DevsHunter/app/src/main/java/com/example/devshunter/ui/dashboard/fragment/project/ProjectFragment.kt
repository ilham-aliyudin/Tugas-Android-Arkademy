package com.example.devshunter.ui.dashboard.fragment.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.devshunter.R
import com.example.devshunter.repository.ProjectRepository
import kotlinx.android.synthetic.main.fragment_project.view.*

class ProjectFragment : Fragment(R.layout.fragment_project){

    private lateinit var viewModel: ProjectViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        view.toolbar_project.setupWithNavController(navController, appBarConfiguration)
        view.add_project_fab.setOnClickListener {
            startActivity(Intent(activity, FormAddProjectActivity::class.java))
        }

        val repository = ProjectRepository()
        val factory = ProjectViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ProjectViewModel::class.java]
        viewModel.getAllProject()
        viewModel.projectResponse.observe(viewLifecycleOwner, {response ->
            if(response.isSuccessful) {
                Log.d("ProjectResponse", response.body()?.message.toString())
            }
        })
    }
}
